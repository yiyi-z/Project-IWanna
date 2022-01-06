package tilegame.ui;

import java.awt.Graphics;
import java.awt.Rectangle;

import tilegame.Handler;

public abstract class UIObject 
{
	protected Handler handler;
	protected float x, y;
	protected int width, height;
	protected Rectangle bounds; // the area of the button
	protected boolean hovering = false;
	
	public UIObject(Handler handler, float x, float y, int width, int height)
	{
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		bounds = new Rectangle((int) x, (int) y, width, height);
	}
	
	/**
	 * update the uiObject
	 */
	public abstract void tick();
	
	/**
	 * draw the updated uiObject
	 * @param g
	 */
	public abstract void render(Graphics g);
	
	/**
	 * the action takes when the uiObject is clicked
	 */
	public abstract void onClick();
	
	/**
	 * check if the mouse is hovering over the uiObject or not
	 */
	public void onMouseMove()
	{
		if(bounds.contains(handler.getMouseManager().getX(), handler.getMouseManager().getY()))
			hovering = true;
		else
			hovering = false;
	}
	
	/**
	 * check if the mouse's left button is pressed
	 */
	public void onMousePressed()
	{
		if(hovering && handler.getMouseManager().isLeftClicked())
			{
			onClick();
			handler.getMouseManager().setLeftClicked(false);
			}
		
	}
	
	// Getters and setters

	public float getX() 
	{
		return x;
	}

	public void setX(float x) 
	{
		this.x = x;
	}

	public float getY() 
	{
		return y;
	}

	public void setY(float y) 
	{
		this.y = y;
	}

	public int getWidth() 
	{
		return width;
	}

	public void setWidth(int width)
	{
		this.width = width;
	}

	public int getHeight() 
	{
		return height;
	}

	public void setHeight(int height)
	{
		this.height = height;
	}

	public boolean isHovering()
	{
		return hovering;
	}

	public void setHovering(boolean hovering)
	{
		this.hovering = hovering;
	}

}
