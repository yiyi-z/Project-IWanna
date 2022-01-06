package tilegame.ui;

import tilegame.Handler;
import tilegame.states.State;

public class ChooseLevelButton extends UITextButton
{
	public ChooseLevelButton(Handler handler, float x, float y, int width, int height) 
	{
		super(handler, x, y, width, height, "Choose Level");	
	}
	
	/**
	 * change the state to the levelState
	 */
	@Override
	public void onClick() 
	{
		State.setState(handler.getLevelState());
	}
}
