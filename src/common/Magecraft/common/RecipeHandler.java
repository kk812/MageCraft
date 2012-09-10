package Magecraft.common;

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
		
	}
	
	public void addShapelessRecipes()
	{
		
	}
	
	public void addFurnaceRecipes()
	{
		
	}
	
}
