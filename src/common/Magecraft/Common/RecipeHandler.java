package Magecraft.Common;

import Magecraft.Common.Blocks.BlocksFile;
import Magecraft.Common.Items.Magecraft_Items;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;

public class RecipeHandler {
	private static RecipeHandler instance;
	
	//handles all mc recipies including my machine variables.
	
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
		GameRegistry.addRecipe(new ItemStack(Magecraft_Main.blockOrb, 1), new Object[] {"X", 'X', Block.dirt});
	}
	
	public void addShapelessRecipes()
	{
		
	}
	
	public void addFurnaceRecipes()
	{
		GameRegistry.addSmelting(Magecraft_Items.getInstance().veriniteChunk.shiftedIndex, new ItemStack(Magecraft_Items.getInstance().veriniteIngot), 0.1F); 
	}

	public void addInbuenerRecipes(InbuenerRecipeHandler i) 
	{
		i.addRecipe(new RecipieInbuenerObj(Item.ingotIron, 2, 4, new ItemStack(Magecraft_Items.getInstance().veriniteIngot, 2)));
	}
}
