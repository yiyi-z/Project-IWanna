package tilegame.ui;

import tilegame.Handler;
import tilegame.states.State;

public class MenuButton extends UITextButton
{
	public MenuButton(Handler handler, float x, float y, int width, int height, String text) 
	{
		super(handler, x, y, width, height, text);
	}

	/**
	 * change the state to the menuState
	 */
	@Override
	public void onClick() 
	{
		State.setState(handler.getMenuState());
	}
}
