package tilegame.entities.creatures;

import java.awt.Rectangle;

import tilegame.Handler;
import tilegame.tiles.Tile;

/**
 * this entity can attack the player; it moves vertically
 */
public abstract class VerAttack extends Creature
{
	private Player player;
	
	private int attackTime = 0;
	
	public VerAttack(Handler handler, Player player, float x, float y, int width, int height) 
	{
		super(handler, x, y, width, height);
		
		this.player = player;		
	}

	/**
	 * check if the player's bounding box is in the same vertical area of the attack entity's bounding box or not
	 * @return
	 */
	public boolean playerComes()
	{
		if(new Rectangle((int)(x + bounds.x), (int)player.getCollisionBounds(0, 0).getY(), bounds.width, (int) player.getCollisionBounds(0, 0).getHeight()).intersects(new Rectangle(player.getCollisionBounds(0, 0))))
		{			
			if(y + bounds.y > (player.getCollisionBounds(0, 0).getY() + player.getCollisionBounds(0, 0).getHeight()))//move up
				yMove = -Math.abs(speed);
			else
				yMove = Math.abs(speed);
			
			attackTime++;	
			return true;
		}
		return false;
	}
	
	/**
	 * move the horAttack entity in y direction
	 */
	@Override
	public void moveY()
	{
		if(yMove > 0)// Moving down
		{
			// Temporary y
			int ty = (int) (y + bounds.y + bounds.height + yMove)/Tile.TILEHEIGHT;
		
			if(!collisionWithTile((int)(x + bounds.x)/Tile.TILEWIDTH, ty) // lower left corner
					&& !collisionWithTile((int)(x + bounds.x + bounds.width)/Tile.TILEWIDTH, ty))// lower right corner
				y += yMove;
			else
				active = false; // if it is going to hit a solid tile, do not tick it anymore
		}
		else if(yMove < 0)// Moving up
		{
			int ty = (int) (y + bounds.y + yMove)/Tile.TILEHEIGHT;
			
			if(!collisionWithTile((int)(x + bounds.x)/Tile.TILEWIDTH, ty) // upper left corner
					&& !collisionWithTile((int)(x + bounds.x + bounds.width)/Tile.TILEWIDTH, ty))// upper right corner
				y += yMove;
			else
				active = false;
		}
	}
	
	/**
	 * update the horAttackEntity
	 */
	@Override
	public void tick() 
	{
		if(active)
		{
			if(attackTime == 0)
			{
				if(playerComes())
					moveY();
			}
			else
				moveY();
			if(new Rectangle((int)(x + bounds.x), (int)(y + bounds.y), bounds.width, bounds.height).intersects(new Rectangle(player.getCollisionBounds(0, 0))))
				player.active = false;
		}		
	}

}
