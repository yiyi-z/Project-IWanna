package tilegame.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;

import tilegame.Handler;
import tilegame.entities.creatures.Player;
import tilegame.graphics.Assets;
import tilegame.graphics.Text;

/**
 * Manage all the entities
 */
public class EntityManager 
{
	private Handler handler;
	private Player player;
	private ArrayList<Entity> entitiyset; // stores all entity instances of the current game level
	private Comparator<Entity> renderSorter = new Comparator<Entity>() // compares the button line of the entities
			{
				@Override
				public int compare(Entity a, Entity b) 
				{
					if(a.getY() + a.getHeight() < b.getY() + b.getHeight())
						return -1;
					return 1;
				}	
			};
	
	public EntityManager(Handler handler, Player player)
	{
		this.handler = handler;
		this.player = player;
		entitiyset = new ArrayList<Entity>();
		addEntity(player);	
	}	
	
	/**
	 * tick all the entities
	 */
	public void tick() 
	{
		for(int i = 0; i < entitiyset.size(); i++)
		{
			Entity e = entitiyset.get(i);
			e.tick();
		}
		entitiyset.sort(renderSorter);
	}
	
	/**
	 * render all the entities
	 * @param g
	 */
	public void render(Graphics g)
	{
		for (Entity e : entitiyset)
			e.render(g);
		if(!player.isActive()||player.isWin())
			postRender(g);
	}
	
	/**
	 * render after all the entities have rendered
	 * @param g
	 */
	public void postRender(Graphics g)
	{
		if(player.isWin())
			Text.drawString(g, "You win.", handler.getWidth()/2, handler.getHeight()/2, true, Color.BLACK, Assets.font45);	
		else
			Text.drawString(g, "You die.", handler.getWidth()/2, handler.getHeight()/2, true, Color.BLACK, Assets.font45);
	}
	
	
	/**
	 * add an entity to the arrayList 
	 * @param e
	 */
	public void addEntity(Entity e)
	{
		entitiyset.add(e);
	}

	// getters and setters
	
	public Handler getHandler() 
	{
		return handler;
	}

	public void setHandler(Handler handler)
	{
		this.handler = handler;
	}

	public Player getPlayer() 
	{
		return player;
	}

	public void setPlayer(Player player) 
	{
		this.player = player;
	}

	public ArrayList<Entity> getEntities() 
	{
		return entitiyset;
	}

	public void setEntities(ArrayList<Entity> entities) 
	{
		this.entitiyset = entities;
	}

}
