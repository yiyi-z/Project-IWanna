package tilegame.ui;

import java.awt.Color;
import java.awt.Graphics;

import tilegame.Handler;
import tilegame.graphics.Assets;
import tilegame.graphics.Text;

public class UITextButton extends UIObject 
{
	private String text;
	
	public UITextButton(Handler handler, float x, float y, int width, int height, String text) 
	{
		super(handler, x, y, width, height);
		this.text = text;
	}

	/**
	 * update the position of the mouse (check if it's hovering), check if it's pressed
	 */
	@Override
	public void tick() 
	{
		onMouseMove();
		onMousePressed();
	}

	/**
	 * draw the button
	 */
	@Override
	public void render(Graphics g) 
	{
		if(hovering)
			Text.drawString(g, text, (int)x, (int)(y+height), false, Color.BLACK, Assets.font30);
		else
			Text.drawString(g, text, (int)x, (int)(y+height), false, Color.DARK_GRAY, Assets.font30);
	}

	/**
	 * the action takes when the button is clicked
	 */
	@Override
	public void onClick() 
	{
		
	}

}