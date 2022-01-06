package tilegame.entities.creatures;

import java.awt.Graphics;

import tilegame.Handler;
import tilegame.graphics.Assets;

/**
 * this entity can attack the player; it moves horizontally; it uses the image of a tree
 */
public class HorTree extends HorAttack
{
	public HorTree(Handler handler, Player player, float x, float y) 
	{
		super(handler, player, x, y, 96, 128); //width and height of the tree are fixed
		speed = 5; 
		
		// set the bounding box (hitting)
		bounds.x = 4;
		bounds.y = 73;
		bounds.width = 85;
		bounds.height = 40;		
	}

	/**
	 * draw the horTree
	 */
	@Override
	public void render(Graphics g) 
	{
		g.drawImage(Assets.tree, (int)(x + handler.getGameCamera().getxOffset()), (int)(y + handler.getGameCamera().getyOffset()), width, height, null);
	}

}
