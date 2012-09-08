package Magecraft.common.Blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.src.Block;
import Magecraft.common.Items.Magecraft_Items;

public class Magecraft_Blocks {

	public Block veriniteOreBlock;
	public Block veriniteIngotBlock;
	
	private Magecraft_Blocks()
	{
		
	}
	
	private static Magecraft_Blocks instance;
	public static void createInstance()
	{
		instance = new Magecraft_Blocks();
	}
	
	public static Magecraft_Blocks getInstance()
	{
		return instance;
	}
	
	public void loadBlocks()
	{
		veriniteOreBlock = new BlockveriniteOre(230, 0).setStepSound(Block.soundStoneFootstep).setHardness(3F).setResistance(1.0F).setBlockName("VeriniteOreBlock");
		
	}
	
	public void registerBlocks()
	{
		GameRegistry.registerBlock(veriniteOreBlock);
		GameRegistry.registerBlock(veriniteIngotBlock);
		LanguageRegistry.addName(veriniteOreBlock, "Verinite Ore");
		LanguageRegistry.addName(veriniteIngotBlock, "Verinite Block");
	}
	
}
