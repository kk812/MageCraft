package Magecraft.common;

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
		GameRegistry.addRecipe(new ItemStack(/*What should I put here*/), new Object[]{"XXX", "X X", "XXX", 'X', Magecraft_Items.getInstance().veriniteIngot.shiftedIndex});
	}
	
	public void addShapelessRecipes()
	{
		
	}
	
	public void addFurnaceRecipes()
	{
		
	}
	
}
