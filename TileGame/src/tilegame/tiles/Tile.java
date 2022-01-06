package tilegame.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile 
{
	public static Tile[] tiles = new Tile[256]; // put one of the each type of the tile in this array
	public static Tile grassTile = new GrassTile(0); // the id of grassTile is 0, and the grassTile is Tile[0]
	public static Tile dirtTile = new DirtTile(1);
	public static Tile wallTile = new WallTile(2);
	public static Tile grass1Tile = new Grass1Tile(3);
	public static Tile grass2Tile = new Grass2Tile(4);
	public static Tile grass3Tile = new Grass3Tile(5);
	public static Tile waterTile = new WaterTile(6);
	
	public static final int TILEWIDTH = 64, TILEHEIGHT = 64;
	
	protected BufferedImage texture;
	protected boolean solid = false; // if the tile is solid, the player cannot walk into
	protected final int id;
	
	public Tile(BufferedImage texture, int id)
	{
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
	}

	/**
	 * draw the tile
	 * @param g
	 * @param x
	 * @param y
	 */
	public void render(Graphics g, int x, int y)
	{
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
	}

	//getters
	public int getId()
	{
		return id;
	}
	
	public boolean isSolid()
	{
		return solid;
	}
	
}
