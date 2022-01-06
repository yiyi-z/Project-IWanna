package tilegame.entities.creatures;

import java.awt.Graphics;

import tilegame.Handler;
import tilegame.graphics.Assets;

/**
 * this entity can attack the player; it moves vertically; it uses the image of a tree
 */
public class VerTree extends VerAttack
{
	public VerTree(Handler handler, Player player, float x, float y) 
	{
		super(handler, player, x, y, 96, 128);//width and height of the tree are fixed
		speed = 8; 
		
		// set the bounding box (hitting)
		bounds.x = 5;
		bounds.y = 19;
		bounds.width = 85;
		bounds.height = 94;		
	}

	/**
	 * draw the verTree
	 */
	@Override
	public void render(Graphics g) 
	{
		g.drawImage(Assets.tree, (int)(x + handler.getGameCamera().getxOffset()), (int)(y + handler.getGameCamera().getyOffset()), width, height, null);
	}	

}
