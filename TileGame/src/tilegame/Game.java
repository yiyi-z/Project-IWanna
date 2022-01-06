package tilegame;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import tilegame.display.Display;
import tilegame.graphics.Assets;
import tilegame.graphics.GameCamera;
import tilegame.input.KeyManager;
import tilegame.input.MouseManager;
import tilegame.states.GameState;
import tilegame.states.InfoState;
import tilegame.states.LevelState;
import tilegame.states.MenuState;
import tilegame.states.State;

public class Game implements Runnable
{
	private Display display;
	private int width, height;
	public String title;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	private GameState gameState;
	private MenuState menuState;
	private InfoState infoState;
	private LevelState levelState;
	
	private KeyManager keyManager;
	private MouseManager mouseManager;
	
	private GameCamera gameCamera;
	
	// Other classes can use handler to access methods in Game class
	private Handler handler;

	public Game(String title, int width, int height)
	{
		this.width = width;
		this.height = height;
		this.title = title;		
	}
	
	/**
	 * initialize keyManager, mouseManager, display, handler, gameCamera and states
	 */
	private void init()
	{
		keyManager = new KeyManager();
		mouseManager = new MouseManager();
		
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager); //depends on which elements in the Jframe are currently focused 
		display.getCanvas().addMouseMotionListener(mouseManager);
		Assets.init();
		
		handler = new Handler(this);
		gameCamera = new GameCamera(handler, 0, 0);
		
		gameState = new GameState(handler, "res/tiles/tiles1.txt", "res/entities/entities1.txt");
		menuState = new MenuState(handler);
		infoState = new InfoState(handler);
		levelState = new LevelState(handler);
		State.setState(menuState);
	}
	
	/**
	 * update each objects
	 */
	private void tick()
	{
		keyManager.tick();
		
		if(State.getState() != null)
			State.getState().tick();
	}
	
	/**
	 * draw the updated object
	 */
	private void render()
	{
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null)
		{
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		
		g = bs.getDrawGraphics();
		// Clear Screen
		g.clearRect(0, 0, width, height);
		// draw 		
		if(State.getState() != null)
			State.getState().render(g);
		// end drawing
		bs.show();
		g.dispose(); 
	}
	
	/**
	 * initialize and run the game, refresh 60 times a second
	 */
	public void run()
	{
		init();
		
		int fps = 60;
		double timePerTick = 1000000000/fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
				
		while(running)
		{
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			lastTime = now;
			
			if(delta >= 1) 
			{
				tick();
				render();
				delta--;
			}		
		}		
		stop();
	}
	
	/**
	 * set the running to true, call the start() of this thread which calls the run()
	 */
	public synchronized void start()
	{
		// in case we accidently call the start again when the game is running
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	/**
	 * close the thread
	 */
	public synchronized void stop()
	{
		if(!running)
			return;
		try 
		{
			thread.join();
		} 
		catch (InterruptedException e) 
		{		
			e.printStackTrace();
		}
	}
	
	
	// Getters
	
	public KeyManager getKeyManager()
	{
		return keyManager;
	}
	
	public MouseManager getMouseManager()
	{
		return mouseManager;		
	}
	
	public GameCamera getGameCamera()
	{
		return gameCamera;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public GameState getGameState() 
	{
		return gameState;
	}

	public MenuState getMenuState() 
	{
		return menuState;
	}
	
	public InfoState getInfoState()
	{
		return infoState;
	}
	
	public LevelState getLevelState()
	{
		return levelState;
	}
	
	public void setGameState(GameState gameState)
	{
		this.gameState = gameState;
	}
	
}
