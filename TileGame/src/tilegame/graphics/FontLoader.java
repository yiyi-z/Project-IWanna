package tilegame.graphics;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

public class FontLoader 
{
	/**
	 * load the font from the file
	 * @param path
	 * @param size
	 * @return
	 */
	public static Font loadFont(String path, float size)
	{
		try 
		{
			return Font.createFont(Font.TRUETYPE_FONT, new File(path)).deriveFont(Font.PLAIN, size);
		} 
		catch (FontFormatException e) 
		{
			e.printStackTrace();
			System.exit(1);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}

}
