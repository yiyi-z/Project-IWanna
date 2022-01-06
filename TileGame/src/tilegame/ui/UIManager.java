package tilegame.ui;

import java.awt.Graphics;
import java.util.ArrayList;

import tilegame.Handler;

public class UIManager 
{
	private Handler handler;
	private ArrayList<UIObject> objects;
	
	public UIManager(Handler handler)
	{
		this.handler = handler;
		objects = new ArrayList<UIObject>();
	}
	
	/**
	 * tick all the uiObjects
	 */
	public void tick()
	{
		for(UIObject o : objects)
			o.tick();
	}
	
	/**
	 * render all the uiObjects
	 * @param g
	 */
	public void render(Graphics g)
	{
		for(UIObject o : objects)
			o.render(g);
	}

	/**
	 * add an uiObject to the array
	 * @param o
	 */
	public void addObject(UIObject o)
	{
		objects.add(o);
	}
	
	/**
	 * remove an uiObject from the array
	 * @param o
	 */
	public void removeObject(UIObject o)
	{
		objects.remove(o);
	}

	// getters and setters
	
	public Handler getHandler() 
	{
		return handler;
	}

	public void setHandler(Handler handler) 
	{
		this.handler = handler;
	}

	public ArrayList<UIObject> getObjects() 
	{
		return objects;
	}

	public void setObjects(ArrayList<UIObject> objects) 
	{
		this.objects = objects;
	}
	
}