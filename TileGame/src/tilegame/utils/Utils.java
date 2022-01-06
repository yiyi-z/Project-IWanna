package tilegame.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Utils 
{	
	/**
	 * load file as string
	 * @param path
	 * @return
	 */
	public static String loadFileAsString(String path)
	{
		StringBuilder builder = new StringBuilder();
		
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader(path));
			String line;
			while ((line = reader.readLine()) != null)
			{
				builder.append(line + "\n");
			}
			reader.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		return builder.toString();
	}
	
	/**
	 * parse string to int
	 * @param number
	 * @return
	 */
	public static int parseInt(String number)
	{
		try 
		{
			return Integer.parseInt(number);
		}
		catch(NumberFormatException e)
		{
			e.printStackTrace();
			return 0;
		}		
	}
	
}
