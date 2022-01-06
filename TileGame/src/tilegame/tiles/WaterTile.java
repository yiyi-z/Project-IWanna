package tilegame.tiles;

import tilegame.graphics.Assets;

public class WaterTile extends Tile
{
	public WaterTile(int id)
	{
		super(Assets.water, id);
		solid = true; // cannot walk into the water
	}

}
