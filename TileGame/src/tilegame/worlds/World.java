package tilegame.worlds;

import java.awt.Graphics;

import tilegame.Handler;
import tilegame.entities.EntityManager;
import tilegame.entities.creatures.HorTree;
import tilegame.entities.creatures.HorWall;
import tilegame.entities.creatures.Player;
import tilegame.entities.creatures.VerTree;
import tilegame.entities.creatures.VerWall;
import tilegame.entities.statics.Tree;
import tilegame.tiles.Tile;
import tilegame.utils.Utils;

public class World 
{
	private Handler handler;
	public int width, height;
	private int pStartX, pStartY; //player starts at what position
	public int[][] tileset; //at [x][y], what tile it is
	private EntityManager entityManager;
	
	
	public World(Handler handler, String pathWorld, String pathEntities)
	{
		this.handler = handler;
		entityManager = new EntityManager(handler, new Player(handler, 0, 0));
	
		loadTiles(pathWorld);
		
		entityManager.getPlayer().setX(pStartX);
		entityManager.getPlayer().setY(pStartY);
		
		loadEntity(pathEntities);
	}
	
	/**
	 * update the entities
	 */
	public void tick()
	{
		entityManager.tick();
	}
	
	/**
	 * draw the tiles and the entities
	 * @param g
	 */
	public void render(Graphics g)
	{
		// only render the tiles that the user can see
		int xStart = (int)Math.max(0, 0-handler.getGameCamera().getxOffset()/Tile.TILEWIDTH);
		int xEnd = (int)Math.min(width - 1, (handler.getWidth()-handler.getGameCamera().getxOffset())/Tile.TILEWIDTH);
		int yStart = (int)Math.max(0, 0-handler.getGameCamera().getyOffset()/Tile.TILEHEIGHT);
		int yEnd = (int)Math.min(height - 1, (handler.getHeight()-handler.getGameCamera().getyOffset())/Tile.TILEHEIGHT);
		
		for (int y = yStart; y <= yEnd; y++)
		{
			for (int x = xStart; x <= xEnd; x++)
			{
				getTile(x,y).render(g, (int)(x*Tile.TILEWIDTH + handler.getGameCamera().getxOffset()), (int)(y*Tile.TILEHEIGHT + handler.getGameCamera().getyOffset()));
			}
		}		
		entityManager.render(g);
	}
	
	public Tile getTile(int x, int y)
	{
		if(x < 0 || y < 0 || x >= width || y >= height)
			return Tile.grassTile;
		
		Tile t = Tile.tiles[tileset[x][y]];
		
		if (t == null)
			return Tile.dirtTile;
		
		return t;
	}
	
	/**
	 * load the tiles from the file
	 * @param path
	 */
	public void loadTiles(String path)
	{
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]); // how many tiles
		height = Utils.parseInt(tokens[1]);
		pStartX = Utils.parseInt(tokens[2]); // pixel
		pStartY = Utils.parseInt(tokens[3]);
		
		tileset = new int[width][height];
		for (int y = 0; y < height; y++)
		{
			for (int x = 0; x < width; x++)
			{
				tileset[x][y] = Utils.parseInt(tokens[4 + y * width + x]);
			}
		}		
	}
	
	/**
	 * load the entities from the file
	 * @param path
	 */
	public void loadEntity(String path)
	{
		String file = Utils.loadFileAsString(path);// the entity allocated in which tile
		String[] tokens = file.split("\\s+");
		
		int numOfVerTree = Utils.parseInt(tokens[0]); 
		int numOfVerWall = Utils.parseInt(tokens[1]);
		int numOfHorTree = Utils.parseInt(tokens[2]); 
		int numOfHorWall = Utils.parseInt(tokens[3]);
		int numOfStaticTree = Utils.parseInt(tokens[4]);
		
		for(int i = 0; i < numOfVerTree; i++)
		{
			int x = Utils.parseInt(tokens[i*2+5])*Tile.TILEWIDTH;
			int y = Utils.parseInt(tokens[i*2+5+1])*Tile.TILEHEIGHT - 51;
			entityManager.addEntity(new VerTree(handler, this.entityManager.getPlayer(), x, y));
		}
		for(int i = 0; i < numOfVerWall; i++)
		{
			int x = Utils.parseInt(tokens[i*2+5+numOfVerTree*2])*Tile.TILEWIDTH;
			int y = Utils.parseInt(tokens[i*2+5+1+numOfVerTree*2])*Tile.TILEHEIGHT;
			entityManager.addEntity(new VerWall(handler, this.entityManager.getPlayer(), x, y));
		}
		for(int i = 0; i < numOfHorTree; i++)
		{
			int x = Utils.parseInt(tokens[i*2+5+numOfVerTree*2+numOfVerWall*2])*Tile.TILEWIDTH;
			int y = Utils.parseInt(tokens[i*2+5+1+numOfVerTree*2+numOfVerWall*2])*Tile.TILEHEIGHT-51;
			entityManager.addEntity(new HorTree(handler, this.entityManager.getPlayer(), x, y));
		}
		for(int i = 0; i < numOfHorWall; i++)
		{
			int x = Utils.parseInt(tokens[i*2+5+numOfVerTree*2+numOfVerWall*2+numOfHorTree*2])*Tile.TILEWIDTH;
			int y = Utils.parseInt(tokens[i*2+5+1+numOfVerTree*2+numOfVerWall*2+numOfHorTree*2])*Tile.TILEHEIGHT;
			entityManager.addEntity(new HorWall(handler, this.entityManager.getPlayer(), x, y));
		}
		for(int i = 0; i < numOfStaticTree; i++)
		{
			int x = Utils.parseInt(tokens[i*2+5+numOfVerTree*2+numOfVerWall*2+numOfHorTree*2+numOfHorWall*2])*Tile.TILEWIDTH;
			int y = Utils.parseInt(tokens[i*2+5+1+numOfVerTree*2+numOfVerWall*2+numOfHorTree*2+numOfHorWall*2])*Tile.TILEHEIGHT-51;
			entityManager.addEntity(new Tree(handler, x, y));
		}
	}
	
	// getters and setters

	public int getpStartX() 
	{
		return pStartX;
	}

	public int getpStartY() 
	{
		return pStartY;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public int getHeight()
	{
		return height;
	}

	public EntityManager getEntityManager() 
	{
		return entityManager;
	}
	



}
