package tilegame.ui;

import tilegame.Handler;
import tilegame.states.State;

public class InfoButton extends UITextButton
{
	public InfoButton(Handler handler, float x, float y, int width, int height) 
	{
		super(handler, x, y, width, height, "Info");		
	}
	
	/**
	 * change the state to the inFoState
	 */
	@Override
	public void onClick() 
	{
		State.setState(handler.getInfoState());
	}

}
