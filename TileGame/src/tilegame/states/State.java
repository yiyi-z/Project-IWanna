package tilegame.states;

import java.awt.Graphics;

import tilegame.Handler;

public abstract class State 
{
	private static State currentState = null;
	
	protected Handler handler;
	
	public State(Handler handler)
	{
		this.handler = handler;
	}
	
	/**
	 * update the state
	 */
	public abstract void tick();
	
	/**
	 * draw the updated state
	 * @param g
	 */
	public abstract void render(Graphics g);
	
	// getters and setters
	
	public static void setState (State state)
	{
		currentState = state;
	}
	
	public static State getState()
	{
		return currentState;
	}
}
