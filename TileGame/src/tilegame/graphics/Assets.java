package tilegame.graphics;

import java.awt.Font;
import java.awt.image.BufferedImage;

public class Assets 
{
	private static final int width = 16, height = 16;

	public static Font font30, font45; // size 30, size 45

	public static BufferedImage[] playerDown, playerUp, playerLeft, playerRight;
	public static BufferedImage tree, playerD, playerU, playerL, playerR, dead, grass, grass1, grass2, grass3, water, wall, dirt, flower, door;
		
	/**
	 * initialize the image
	 * crop each image from the spriteSheet
	 */
	public static void init()
	{
		// load font
		font30 = FontLoader.loadFont("res/fonts/slkscr.ttf", 30);
		font45 = FontLoader.loadFont("res/fonts/slkscr.ttf", 45);
		// load image
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/spritesheet.png"));
			
		playerDown = new BufferedImage[2];
		playerUp = new BufferedImage[2];
		playerLeft = new BufferedImage[2];
		playerRight = new BufferedImage[2];
				
		playerDown[0] = sheet.crop(width*4, height*4, width*2, height*2);
		playerDown[1] = sheet.crop(0, height*6, width*2, height*2);
	
		playerLeft[0] = sheet.crop(0, 0, width*2, height*2);
		playerLeft[1] = sheet.crop(width*4, height*6, width*2, height*2);
			
		playerUp[0] = sheet.crop(0, height*4, width*2, height*2);
		playerUp[1] = sheet.crop(width*2, height*4, width*2, height*2);
		
		playerRight[0] = sheet.crop(width*2, 0, width*2, height*2);
		playerRight[1] = sheet.crop(width*2, height*2, width*2, height*2);
		
		playerD = sheet.crop(width*4, height*2, width*2, height*2);
		playerL = sheet.crop(width*2, height*6, width*2, height*2);
		playerU = sheet.crop(0, height*4, width*2, height*2);
		playerR = sheet.crop(0, height*2, width*2, height*2);
		dead = ImageLoader.loadImage("/textures/death.png");
		
		flower = sheet.crop(width*9, height*13, width, height);
		tree = sheet.crop(width*6, 0, width * 6, height * 8);
				
		grass = sheet.crop(width*6, height*11, width*3, height*3);
		grass1 = sheet.crop(0, height*8, width*3, height*3);
		grass2 = sheet.crop(width*3, height*8, width*3, height*3);
		grass3 = sheet.crop(width*9, height*8, width*3, height*3);
		water = sheet.crop(width*6, height*8, width*3, height*3);
		wall = sheet.crop(width * 3, height*11, width*3, height*3);
		dirt = sheet.crop(width*9, height*11, width*2, height*2);	
	}
	
}
