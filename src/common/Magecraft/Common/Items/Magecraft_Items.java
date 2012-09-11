package Magecraft.Common.Items;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.src.Item;

public class Magecraft_Items 
{
	//Item variables
	public Item veriniteChunk;
	public Item veriniteIngot;
	public Item veriniteEssence;
	
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
	
	public void instantiateItems()
	{
		veriniteChunk = new VeriniteChunk(550).setIconIndex(0).setItemName("VeriniteChunk");
		veriniteIngot = new VeriniteIngot(551).setIconIndex(1).setItemName("VeriniteIngot");
		veriniteEssence = new VeriniteEssence(552).setIconIndex(2).setItemName("VeriniteEssence");
	}
	
	public void nameItems()
	{
		LanguageRegistry.addName(veriniteChunk, "Verinite Chunk");
		LanguageRegistry.addName(veriniteIngot, "Verinite Ingot");
		LanguageRegistry.addName(veriniteEssence, "Verinite Essence");
	}
	
	
}
