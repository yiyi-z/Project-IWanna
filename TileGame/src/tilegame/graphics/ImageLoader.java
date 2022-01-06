package tilegame.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader 
{
	/**
	 * load the image from the file
	 * @param path
	 * @return
	 */
	public static BufferedImage loadImage(String path)
	{
		try 
		{
			return ImageIO.read(ImageLoader.class.getResource(path));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		    System.exit(1);
		}
		return null;		
	}
	
}
