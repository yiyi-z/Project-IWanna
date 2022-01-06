package tilegame.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import tilegame.Handler;

/**
 * objects on the tiles
 */
public abstract class Entity 
{
	protected Handler handler;
	protected float x, y;
	protected int width, height;
	protected Rectangle bounds; //the part of the entity that can collide with other entities
	
	public Entity(Handler handler, float x, float y, int width, int height)
	{
		this.handler = handler;
		this.x = x;
		this.y = y;		
		this.width = width;
		this.height = height;
		
		// default bounding box has the same size of the creature image
		bounds = new Rectangle(0, 0, width, height);
	}

	/**
	 * update the entity
	 */
	public abstract void tick();
	
	/**
	 * draw the updated entity
	 * @param g
	 */
	public abstract void render(Graphics g);
	
	/**
	 * check if an entity collide with any other entities or not
	 * @param xMove
	 * @param yMove
	 * @return
	 */
	public boolean checkEntityCollisions(float xMove, float yMove)
	{
		for(Entity e: handler.getWorld().getEntityManager().getEntities())
		{
			if(e.equals(this)) // escape the entity itself
				continue;
			if(e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xMove, yMove))) //compare all the static entities to the moving creature that calls the method 
				return true;
		}
		return false;
	}
	
	/**
	 * get the bounding box of an entity 
	 * the bounding box is in where it originally will be in the next 1/60 second
	 * @param xMove
	 * @param yMove
	 * @return
	 */
	public Rectangle getCollisionBounds(float xMove, float yMove)
	{
		return new Rectangle((int)(x + bounds.x + xMove), (int)(y + bounds.y + yMove), bounds.width, bounds.height);
	}
	
	//Getters and setters
	
	public float getX() 
	{
		return x;
	}

	public float getY() 
	{
		return y;
	}
	
	public void setX(float x)
	{
		this.x = x;
	}
	
	public void setY(float y)
	{
		this.y = y;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public int getHeight()
	{
		return height;
	}

}
