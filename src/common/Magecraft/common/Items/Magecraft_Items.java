package Magecraft.common.Items;

public class Magecraft_Items {
	
	private Magecraft_Items()
	{
		
	}
	
	private static Magecraft_Items instance;
	public static void createInstance()
	{
		instance = new Magecraft_Items();
	}
	
	public static Magecraft_Items getInstance()
	{
		return instance;
	}
	
	
}
