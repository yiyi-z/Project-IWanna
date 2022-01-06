package tilegame.graphics;

import tilegame.Handler;
import tilegame.entities.Entity;
import tilegame.tiles.Tile;

/**
 * set the xOffset and yOffset for the objects, so that it can be shown in the frame
 */
public class GameCamera 
{
	private Handler handler;
	private float xOffset, yOffset;
	
	public GameCamera(Handler handler, float xOffset, float yOffset)
	{
		this.handler = handler;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
	/**
	 * set the offset based on player's position
	 * @param e
	 */
	public void centerOnEntity(Entity e)
	{
		xOffset = handler.getWidth()/2 - (e.getX() + e.getWidth()/2);
		yOffset = handler.getHeight()/2 - (e.getY() + e.getHeight()/2);
		checkBlankSpace();
	}
	
	/**
	 * if the offset will cause to leave some whitespace in the frame, set the offset to 0
	 */
	public void checkBlankSpace() // like the offset does not need to work on these areas
	{
		if (xOffset > 0)
			xOffset = 0;
		else if (xOffset < 0 - handler.getWorld().getWidth() * Tile.TILEWIDTH + handler.getWidth())
			xOffset = 0 - handler.getWorld().getWidth() * Tile.TILEWIDTH + handler.getWidth();
		
		if (yOffset > 0)
			yOffset = 0;
		else if (yOffset < 0 - handler.getWorld().getHeight() * Tile.TILEHEIGHT + handler.getHeight())
			yOffset = 0 - handler.getWorld().getHeight() * Tile.TILEHEIGHT + handler.getHeight();
			
	}
	
	// getters and setters
	public float getxOffset() 
	{
		return xOffset;
	}

	public void setxOffset(float xOffset) 
	{
		this.xOffset = xOffset;
	}

	public float getyOffset() 
	{
		return yOffset;
	}

	public void setyOffset(float yOffset) 
	{
		this.yOffset = yOffset;
	}
	
}
