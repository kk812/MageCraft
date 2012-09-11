package Magecraft.common;

import Magecraft.common.Blocks.BlocksFile;
import Magecraft.common.Items.Magecraft_Items;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;

public class RecipeHandler {
	private static RecipeHandler instance;
	
	public RecipeHandler()
	{
		
	}
	
	public static void createInstance()
	{
		instance = new RecipeHandler();
	}
	
	public static RecipeHandler getInstance()
	{
		return instance;
	}
	
	public void addCraftingTableRecipes()
	{
		GameRegistry.addRecipe(new ItemStack(Magecraft_Main.blocks, 1, 1), new Object[]{"XXX", "X X", "XXX", 'X', Magecraft_Items.getInstance().veriniteIngot});
		GameRegistry.addRecipe(new ItemStack(Magecraft_Items.getInstance().veriniteIngot, 8), new Object[]{"X", 'X', new ItemStack(Magecraft_Main.blocks, 1, 1)});
		GameRegistry.addRecipe(new ItemStack(Magecraft_Items.getInstance().veriniteEssence, 8), new Object[]{"X X", " X ", 'X', Magecraft_Items.getInstance().veriniteIngot});
	}
	
	public void addShapelessRecipes()
	{
		
	}
	
	public void addFurnaceRecipes()
	{
		GameRegistry.addSmelting(Magecraft_Items.getInstance().veriniteChunk.shiftedIndex, new ItemStack(Magecraft_Items.getInstance().veriniteIngot), 0.1F); 
	}
	
}
