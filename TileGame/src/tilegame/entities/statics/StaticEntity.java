package tilegame.entities.statics;

import tilegame.Handler;
import tilegame.entities.Entity;

/**
 * entity does not does not move
 */
public abstract class StaticEntity extends Entity
{
	public StaticEntity(Handler handler, float x, float y, int width, int height)
	{
		super(handler, x, y, width, height);
	}
}
