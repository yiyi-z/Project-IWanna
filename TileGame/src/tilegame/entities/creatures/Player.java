package tilegame.entities.creatures;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import tilegame.Handler;
import tilegame.graphics.Animation;
import tilegame.graphics.Assets;
import tilegame.tiles.Tile;

public class Player extends Creature
{
	private Animation animDown, animUp, animLeft, animRight;
	private boolean win = false;
	
	public Player(Handler handler, float x, float y) 
	{
		super(handler, x, y, 64, 64);//width and height of the tree are fixed
	
		bounds.x = 14;
		bounds.y = 38;
		bounds.width = 34;
		bounds.height = 26;
		
		animDown = new Animation(400, Assets.playerDown);
		animUp = new Animation(400, Assets.playerUp);
		animLeft = new Animation(400, Assets.playerLeft);
		animRight = new Animation(400, Assets.playerRight);		
	}

	/**
	 * get the key input
	 */
	private void getInput()
	{
		xMove = 0;
		yMove = 0;
		
		if(handler.getKeyManager().up)
			yMove -= speed;
		if (handler.getKeyManager().down)
			yMove += speed;
		if (handler.getKeyManager().left)
			xMove -= speed;
		if (handler.getKeyManager().right)
			xMove += speed;
	}	
	
	@Override
	/**
	 * move the player in x direction
	 */
	public void moveX()
	{
		if(xMove > 0)// Moving right
		{
			// Temporary x, will get into which tile (index)
			int tx = (int) (x + bounds.x + bounds.width + xMove)/Tile.TILEWIDTH;
		
			if(!collisionWithTile(tx, (int)(y + bounds.y)/Tile.TILEHEIGHT) // upper right corner with the tile
					&& !collisionWithTile(tx, (int)(y + bounds.y + bounds.height)/Tile.TILEHEIGHT) // lower right corner with the tile
					&& !checkEntityCollisions(xMove, 0f)) // with other entities
			{
				x += xMove; // will not collide, the collision is not perfect now since it may leave a gap that less than the speed
			}
			
		}
		else if(xMove < 0)// Moving left
		{
			int tx = (int) (x + bounds.x + xMove)/Tile.TILEWIDTH;
			
			if(!collisionWithTile(tx, (int)(y + bounds.y)/Tile.TILEHEIGHT) // upper left corner
					&& !collisionWithTile(tx, (int)(y + bounds.y + bounds.height)/Tile.TILEHEIGHT)// lower left corner
					&& !checkEntityCollisions(xMove, 0f)) 
			{
				x += xMove;
			}		
		}		
	}
	
	@Override
	/**
	 * move the player in y direction
	 */
	public void moveY()
	{
		if(yMove > 0)// Moving down
		{
			// Temporary y
			int ty = (int) (y + bounds.y + bounds.height + yMove)/Tile.TILEHEIGHT;
		
			if(!collisionWithTile((int)(x + bounds.x)/Tile.TILEWIDTH, ty) // lower left corner
					&& !collisionWithTile((int)(x + bounds.x + bounds.width)/Tile.TILEWIDTH, ty)// lower right corner
					&& !checkEntityCollisions(0f, yMove)) 
			{
				y += yMove;
			}
		}
		else if(yMove < 0)// Moving up
		{
			int ty = (int) (y + bounds.y + yMove)/Tile.TILEHEIGHT;
			
			if(!collisionWithTile((int)(x + bounds.x)/Tile.TILEWIDTH, ty) // upper left corner
					&& !collisionWithTile((int)(x + bounds.x + bounds.width)/Tile.TILEWIDTH, ty)// upper right corner
					&& !checkEntityCollisions(0f, yMove)) 
			{
				y += yMove;
			}
		}
	}
	
	@Override
	/**
	 * tick the player (animation, x, y)
	 */
	public void tick() 
	{
		if(active)
		{
			animDown.tick();
			animUp.tick();
			animLeft.tick();
			animRight.tick();
			
			isWin();
			getInput(); // where the player wants to move to
			move(); // make the possible moves
			handler.getGameCamera().centerOnEntity(this); //update the xOffset and yOffset
		}
	
	}
  	
	/**
	 * render the player
	 */
	@Override
	public void render(Graphics g) 
	{
		if(active)
		{
			g.drawImage(getCurrentPlayerImage(), (int)(x + handler.getGameCamera().getxOffset()), (int)(y + handler.getGameCamera().getyOffset()), width, height, null);
			if (win)
				active = false;	
		}		
		else
		{
			if(win)
				g.drawImage(getCurrentPlayerImage(), (int)(x + handler.getGameCamera().getxOffset()), (int)(y + handler.getGameCamera().getyOffset()), width, height, null);			
			else
				g.drawImage(Assets.dead, (int)(x + handler.getGameCamera().getxOffset()), (int)(y + handler.getGameCamera().getyOffset()), width, height, null);				
		}			
	}
	
	/**
	 * check if the player reaches the end of not
	 */
	public boolean isWin()
	{
		if(x + width >= handler.getWorld().tileset.length*Tile.TILEWIDTH)
			win = true;
		else
			win = false;
		
		return win;
	}
	
	/**
	 * get the current player image (move or the standing still)
	 */
	private BufferedImage getCurrentPlayerImage()
	{
		if (xMove < 0)
			return animLeft.getCurrentFrame();
		else if (xMove > 0)
			return animRight.getCurrentFrame();
		else if (yMove < 0)
			return animUp.getCurrentFrame();
		else if (yMove > 0)
			return animDown.getCurrentFrame();
		else if (handler.getKeyManager().stopLeft)
			return Assets.playerL;
		else if (handler.getKeyManager().stopRight)
			return Assets.playerR;
		else if (handler.getKeyManager().stopUp)
			return Assets.playerU;
		else 
			return Assets.playerD;
	}

}
