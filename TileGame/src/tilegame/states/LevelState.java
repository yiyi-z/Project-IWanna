package tilegame.states;

import java.awt.Color;
import java.awt.Graphics;

import tilegame.Handler;
import tilegame.graphics.Assets;
import tilegame.graphics.Text;
import tilegame.ui.Level2Button;
import tilegame.ui.Level1Button;
import tilegame.ui.UIManager;

public class LevelState extends State
{
	private UIManager uiManager;
	
	public LevelState(Handler handler)
	{
		super(handler);
		
		uiManager = new UIManager(handler);
		uiManager.addObject(new Level1Button(handler, 100, handler.getHeight()/3*2, 130, 31, "Level 1"));
		uiManager.addObject(new Level2Button(handler, 500, handler.getHeight()/3*2, 130, 31, "Level 2"));
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
		Text.drawString(g, "Choose Level", 100, 200, false, Color.black, Assets.font45);
		uiManager.render(g);
	}

}
