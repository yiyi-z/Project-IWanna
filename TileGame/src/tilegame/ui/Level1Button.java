package tilegame.ui;

import tilegame.Handler;
import tilegame.states.GameState;
import tilegame.states.State;

public class Level1Button extends UITextButton
{
	public Level1Button(Handler handler, float x, float y, int width, int height, String text) 
	{
		super(handler, x, y, width, height, text);	
	}
	
	/**
	 * change the state to the gameState(level 1)
	 */
	@Override
	public void onClick() 
	{
		handler.getGame().setGameState(new GameState(handler, "res/tiles/tiles1.txt","res/entities/entities1.txt"));
		State.setState(handler.getGameState());
		handler.getGameState().setLevel(1);
	}

}
