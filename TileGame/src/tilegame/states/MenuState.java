package tilegame.states;

import java.awt.Color;
import java.awt.Graphics;

import tilegame.Handler;
import tilegame.graphics.Assets;
import tilegame.graphics.Text;
import tilegame.ui.ChooseLevelButton;
import tilegame.ui.InfoButton;
import tilegame.ui.Level1Button;
import tilegame.ui.UIManager;

public class MenuState extends State
{
	private UIManager uiManager;
	
	public MenuState(Handler handler)
	{
		super(handler);
		
		uiManager = new UIManager(handler);
		uiManager.addObject(new Level1Button(handler, 610, handler.getHeight()/3*2, 98, 31, "Start"));
		uiManager.addObject(new InfoButton(handler, 500, handler.getHeight()/3*2, 70, 31));
		uiManager.addObject(new ChooseLevelButton(handler, 100, handler.getHeight()/3*2, 250, 31));
	}

	/**
	 * tick the uiObjects
	 */
	@Override
	public void tick() 
	{
		uiManager.tick();
	}

	/**
	 * draw the background, the title and the uiObjects
	 */
	@Override
	public void render(Graphics g)
	{
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, handler.getWidth(), handler.getHeight());
		g.setColor(Color.WHITE);
		g.fillRect(50, 50, handler.getWidth()-100, handler.getHeight()-100);
		Text.drawString(g, "I wanna play I wanna", 100, 200, false, Color.black, Assets.font45);
		uiManager.render(g);
	}

}
