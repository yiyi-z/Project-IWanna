package tilegame.tiles;

import tilegame.graphics.Assets;

public class WallTile extends Tile
{
	public WallTile(int id)
	{
		super(Assets.wall, id);
		solid = true; // cannot walk into the wall
	}
		
}
