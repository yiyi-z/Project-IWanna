package tilegame.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseManager implements MouseListener, MouseMotionListener
{
	
	private boolean leftClicked;
	private int x, y; //position

	public MouseManager()
	{
		
	}
	
	/**
	 * check if the left button is clicked or not
	 * @return
	 */
	public boolean isLeftClicked()
	{
		return leftClicked;
	}
	
	@Override
	public void mousePressed(MouseEvent e) 
	{
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) 
	{
		
	}

	/**
	 * calls when the mouse is moved, update the x, y
	 */
	@Override
	public void mouseMoved(MouseEvent e) 
	{
		x = e.getX();
		y = e.getY();
		
	}
	
	@Override
	public void mouseDragged(MouseEvent e) 
	{
			
	}

	/**
	 * calls when the mouse is clicked, check if the left button is clicked or not
	 */
	@Override
	public void mouseClicked(MouseEvent e) 
	{
		if(e.getButton() == MouseEvent.BUTTON1)
			leftClicked = true;	
	}
	

	@Override
	public void mouseEntered(MouseEvent e)
	{
		
	}

	@Override
	public void mouseExited(MouseEvent e) 
	{
		
	}

	// getters and setters
	
	/**
	 * get the x position of the mouse
	 * @return
	 */
	public int getX()
	{
		return x;
	}
	
	/**
	 * get the y position of the mouse
	 * @return
	 */
	public int getY()
	{
		return y;
	}
	
	public void setLeftClicked(boolean leftClicked) 
	{
		this.leftClicked = leftClicked;
	}

}
