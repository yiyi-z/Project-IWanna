package tilegame.entities.creatures;

import tilegame.Handler;
import tilegame.entities.Entity;

/**
 * entities that can move
 */
public abstract class Creature extends Entity
{
	
	public static final float DEFAULT_SPEED = 5.0f;
	
	protected boolean active = true;

	protected float speed;
	protected float xMove, yMove;
	
	public Creature(Handler handler, float x, float y, int width, int height) 
	{
		super(handler, x, y, width, height);
		
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
	}
			
	/**
	 * move the creature in x direction
	 */
	public void moveX()
	{
		
	}
	
	/**
	 * move the creature in y direction
	 */
	public void moveY()
	{
		
	}
	
	/**
	 * move the creature in x and y directions
	 */
	public void move()
	{
		moveX();
		moveY();
	}
	
	
	/**
	 * check if the tile that the creature original will walk into is solid or not
	 * @param x
	 * @param y
	 * @return
	 */
	protected boolean collisionWithTile(int x, int y)
	{
		return handler.getWorld().getTile(x, y).isSolid();
	}
			
	// getters and setters
	
	public float getxMove() 
	{
		return xMove;
	}

	public void setxMove(float xMove) 
	{
		this.xMove = xMove;
	}

	public float getyMove() 
	{
		return yMove;
	}

	public void setyMove(float yMove) 
	{
		this.yMove = yMove;
	}

	public float getSpeed() 
	{
		return speed;
	}

	public void setSpeed(float speed) 
	{
		this.speed = speed;
	}

	public boolean isActive() 
	{
		return active;
	}

	public void setActive(boolean active) 
	{
		this.active = active;
	}	
	
}
