package tilegame.states;

import java.awt.Graphics;

import tilegame.Handler;
import tilegame.ui.InfoButton;
import tilegame.ui.MenuButton;
import tilegame.ui.StartAgainButton;
import tilegame.ui.UIManager;
import tilegame.worlds.World;

public class GameState extends State
{
	private int level = 1;

	private World world;
	private UIManager uiManager;
	
	public GameState(Handler handler, String pathWorld, String pathEntities)
	{
		super(handler);
		world = new World(handler, pathWorld, pathEntities); 
		handler.setWorld(world);
		
		uiManager = new UIManager(handler);
		uiManager.addObject(new StartAgainButton(handler, 175, 450, 210, 32));
		uiManager.addObject(new MenuButton(handler, 450, 450, 85, 31, "menu"));
		uiManager.addObject(new InfoButton(handler, 600, 450, 75, 31));
	}

	/**
	 * tick the world, if the player wins/dies, tick the uiObjects
	 */
	@Override
	public void tick() 
	{
		world.tick();
		if(!handler.getWorld().getEntityManager().getPlayer().isActive())
			uiManager.tick();
		
	}

	/**
	 * render the world, if the player wins/dies, render the uiObjects
	 */
	@Override
	public void render(Graphics g) 
	{
		world.render(g);
		if(!handler.getWorld().getEntityManager().getPlayer().isActive())
			uiManager.render(g);
	}
	
	// getters and setters
	
	public int getLevel() 
	{
		return level;
	}

	public void setLevel(int level) 
	{
		this.level = level;
	}

	
}
