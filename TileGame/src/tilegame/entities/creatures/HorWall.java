package tilegame.entities.creatures;

import java.awt.Graphics;

import tilegame.Handler;
import tilegame.graphics.Assets;

/**
 * this entity can attack the player; it moves horizontally; it uses the image of a wall tile
 */
public class HorWall extends HorAttack
{
	public HorWall(Handler handler, Player player, float x, float y) 
	{
		super(handler, player, x, y, 64, 64); //width and height of the wall are fixed
		speed = 5; 
		
		// set the bounding box (hitting)
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = 64;
		bounds.height = 64;		
	}

	/**
	 * draw the horWall
	 */
	@Override
	public void render(Graphics g) 
	{
		g.drawImage(Assets.wall, (int)(x + handler.getGameCamera().getxOffset()), (int)(y + handler.getGameCamera().getyOffset()), width, height, null);
	}
	
	

}
