package tilegame.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener
{
	
	private boolean[] keys1;
	private boolean[] keys2;
	
	public boolean up, down, left, right; // when pressed
	public boolean stopUp, stopDown, stopLeft, stopRight; // when released
	
	public boolean save;	
	
	public KeyManager()
	{
		keys1 = new boolean[256]; // for move
		keys2 = new boolean[256]; // for stop
	}
	
	/**
	 * tick to get the key input
	 */
	public void tick()
	{
		up = keys1[KeyEvent.VK_W];
		left = keys1[KeyEvent.VK_A];
		down = keys1[KeyEvent.VK_S];
		right = keys1[KeyEvent.VK_D];
		
		stopUp = keys2[KeyEvent.VK_W];
		stopLeft = keys2[KeyEvent.VK_A];
		stopDown = keys2[KeyEvent.VK_S];
		stopRight = keys2[KeyEvent.VK_D];
		
		save = keys1[KeyEvent.VK_CONTROL] && keys1[KeyEvent.VK_S];
	}
	
	/**
	 * it calls when a key is pressed, record which key is pressed
	 */
	@Override
	public void keyPressed(KeyEvent e) 
	{
		keys2[KeyEvent.VK_W] = false;
		keys2[KeyEvent.VK_A] = false;
		keys2[KeyEvent.VK_S] = false;
		keys2[KeyEvent.VK_D] = false;
		
		keys1[e.getKeyCode()] = true;	
	}

	/**
	 * it calls when a key is released, record which key is released
	 */
	@Override
	public void keyReleased(KeyEvent e) 
	{
		keys1[e.getKeyCode()] = false;
		keys2[e.getKeyCode()] = true;	
	}

	@Override
	public void keyTyped(KeyEvent e) 
	{
				
	}	

}
