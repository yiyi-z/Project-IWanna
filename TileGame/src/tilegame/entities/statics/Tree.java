package tilegame.entities.statics;

import java.awt.Graphics;

import tilegame.Handler;
import tilegame.graphics.Assets;

public class Tree extends StaticEntity
{
	public Tree(Handler handler, float x, float y) 
	{
		super(handler, x, y, 96, 128);	
	
		// set the bounding box
		bounds.x = 4;
		bounds.y = 73;
		bounds.width = 85;
		bounds.height = 40;
	}

	/**
	 * update the tree
	 */
	@Override
	public void tick() 
	{
				
	}

	/**
	 * draw the tree
	 */
	@Override
	public void render(Graphics g) 
	{
		g.drawImage(Assets.tree, (int)(x + handler.getGameCamera().getxOffset()), (int)(y + handler.getGameCamera().getyOffset()), width, height, null);		
	}
	
}
