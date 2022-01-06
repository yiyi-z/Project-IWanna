package tilegame.states;

import java.awt.Color;
import java.awt.Graphics;

import tilegame.Handler;
import tilegame.graphics.Assets;
import tilegame.graphics.Text;
import tilegame.ui.MenuButton;
import tilegame.ui.Level1Button;
import tilegame.ui.UIManager;

public class InfoState extends State
{
	private UIManager uiManager;

	public InfoState(Handler handler) 
	{
		super(handler);
		uiManager = new UIManager(handler);
		uiManager.addObject(new Level1Button(handler, 610, handler.getHeight()/3*2, 98, 31, "Start"));
		uiManager.addObject(new MenuButton(handler, 100, handler.getHeight()/3*2, 60, 31, "Back"));
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
	 * draw the background, information and uiObjects
	 */
	@Override
	public void render(Graphics g)
	{
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, handler.getWidth(), handler.getHeight());
		g.setColor(Color.WHITE);
		g.fillRect(50, 50, handler.getWidth()-100, handler.getHeight()-100);
		Text.drawString(g, "Use WASD to control.", 100, 200, false, Color.black, Assets.font45);
		Text.drawString(g, "Help Michelle to pass the forest.", 100, 250, false, Color.black, Assets.font30);
		uiManager.render(g);
	}

}
