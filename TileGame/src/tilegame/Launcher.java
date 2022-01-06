package tilegame;

/**
 * to launch the game
 */
public class Launcher 
{
	public static void main (String[] args)
	{
		Game game = new Game("I WANNA PLAY I WANNA", 832, 576); //13*9
		game.start();
	}

}
