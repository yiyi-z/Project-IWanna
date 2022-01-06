package tilegame.ui;

import tilegame.Handler;
import tilegame.states.GameState;
import tilegame.states.State;

public class StartAgainButton extends UITextButton
{
	public StartAgainButton(Handler handler, float x, float y, int width, int height) 
	{
		super(handler, x, y, width, height, "Start Again");
	}

	/**
	 * restart the level
	 */
	@Override
	public void onClick() 
	{
		if(handler.getGameState().getLevel()==1)
		{
			handler.getGame().setGameState(new GameState(handler, "res/tiles/tiles1.txt","res/entities/entities1.txt"));
			State.setState(handler.getGameState());
			handler.getGameState().setLevel(1);
		}
		if(handler.getGameState().getLevel()==2)
		{
			handler.getGame().setGameState(new GameState(handler, "res/tiles/tiles2.txt","res/entities/entities2.txt"));
			State.setState(handler.getGameState());
			handler.getGameState().setLevel(2);
		}
		
	}
}
