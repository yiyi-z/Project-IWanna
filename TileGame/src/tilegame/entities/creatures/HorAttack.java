package tilegame.entities.creatures;

import java.awt.Rectangle;

import tilegame.Handler;
import tilegame.tiles.Tile;

/**
 * this entity can attack the player; it moves horizontally
 */
public abstract class HorAttack extends Creature
{
	private Player player;
	
	private int attackTime = 0; // the number of times that the attack entity attacks; the attack entity will only attack once
	
	public HorAttack(Handler handler, Player player, float x, float y, int width, int height) 
	{
		super(handler, x, y, width, height);
		
		this.player = player;		
	}

	/**
	 * check if the player's bounding box is in the same horizontal area of the attack entity's bounding box or not
	 * @return
	 */
	public boolean playerComes()
	{
		if(new Rectangle((int)player.getCollisionBounds(0, 0).getX(), (int)(y + bounds.y), (int) player.getCollisionBounds(0, 0).getWidth(), bounds.height).intersects(new Rectangle(player.getCollisionBounds(0, 0))))
		{			
			if(x + bounds.x > player.getCollisionBounds(0, 0).getX() + player.getCollisionBounds(0, 0).getWidth())//move up
				xMove = -Math.abs(speed);
			else
				xMove = Math.abs(speed);
			
			attackTime++;	
			return true;
		}
		return false;
	}
	
	/**
	 * move the horAttack entity in x direction
	 */
	@Override
	public void moveX()
	{
		if(xMove > 0)// Moving right
		{
			// Temporary x, will get into which tile (index)
			int tx = (int) (x + bounds.x + bounds.width + xMove)/Tile.TILEWIDTH;
		
			if(!collisionWithTile(tx, (int)(y + bounds.y)/Tile.TILEHEIGHT) // upper right corner with the tile
					&& !collisionWithTile(tx, (int)(y + bounds.y + bounds.height)/Tile.TILEHEIGHT))// lower right corner with the tile
				x += xMove; // the collision is not perfect now since it may leave a gap that less or equal than the speed
			else
				active = false;	// if it is going to hit a solid tile, set the active to false (will escape most parts of the tick method)	
		}
		else if(xMove < 0)// Moving left
		{
			int tx = (int) (x + bounds.x + xMove)/Tile.TILEWIDTH;
			
			if(!collisionWithTile(tx, (int)(y + bounds.y)/Tile.TILEHEIGHT) // upper left corner
					&& !collisionWithTile(tx, (int)(y + bounds.y + bounds.height)/Tile.TILEHEIGHT))// lower left corner
				x += xMove;
			else
				active = false;
		}		
	}
	
	/**
	 * update the horAttackEntity
	 */
	public void tick() 
	{
		if(active)
		{
			if(attackTime == 0)
			{
				if(playerComes())
					moveX();
			}
			else
				moveX();
			if(new Rectangle((int)(x + bounds.x), (int)(y + bounds.y), bounds.width, bounds.height).intersects(new Rectangle(player.getCollisionBounds(0, 0))))
				player.active = false;
		}			
	}	

}
