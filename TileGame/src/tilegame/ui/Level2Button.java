package tilegame.ui;

import tilegame.Handler;
import tilegame.states.GameState;
import tilegame.states.State;

public class Level2Button extends UITextButton
{
	public Level2Button(Handler handler, float x, float y, int width, int height, String text) 
	{
		super(handler, x, y, width, height, text);		
	}
	
	/**
	 * change the state to the gameState(level 2)
	 */
	@Override
	public void onClick() 
	{
		handler.getGame().setGameState(new GameState(handler, "res/tiles/tiles2.txt","res/entities/entities2.txt"));
		State.setState(handler.getGameState());
		handler.getGameState().setLevel(2);
	}

}
