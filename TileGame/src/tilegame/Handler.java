package tilegame;

import tilegame.graphics.GameCamera;
import tilegame.input.KeyManager;
import tilegame.input.MouseManager;
import tilegame.states.GameState;
import tilegame.states.InfoState;
import tilegame.states.LevelState;
import tilegame.states.MenuState;
import tilegame.worlds.World;

/**
 * to handle the passing of variables
 */
public class Handler 
{
	private Game game;
	private World world;
	
	public Handler (Game game)
	{
		this.game = game;
	}
	
	public GameState getGameState()
	{
		return game.getGameState();
	}
	
	public MenuState getMenuState()
	{
		return game.getMenuState();
	}
	
	public InfoState getInfoState()
	{
		return game.getInfoState();
	}
	
	public LevelState getLevelState()
	{
		return game.getLevelState();
	}

	public GameCamera getGameCamera()
	{
		return game.getGameCamera();
	}
	
	public KeyManager getKeyManager()
	{
		return game.getKeyManager();
	}
	
	public MouseManager getMouseManager()
	{
		return game.getMouseManager();
	}
	
	public int getWidth()
	{
		return game.getWidth();
	}
	
	public int getHeight()
	{
		return game.getHeight();
	}
	
	public Game getGame() 
	{
		return game;
	}

	public World getWorld() 
	{
		return world;
	}

	public void setWorld(World world) 
	{
		this.world = world;
	}
	
	public float getPlayerBoundsX()
	{
		return world.getEntityManager().getPlayer().getCollisionBounds(0, 0).x;
	}
	
}
