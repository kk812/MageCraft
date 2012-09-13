package Magecraft.Common;

import java.util.ArrayList;

import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;

public class InbuenerRecipeHandler 
{
	private static InbuenerRecipeHandler instance;
	
	private ArrayList<RecipieInbuenerObj> recipies = new ArrayList<RecipieInbuenerObj>();
	
	public static void createInstance()
	{
		instance = new InbuenerRecipeHandler();
	}
	
	public static InbuenerRecipeHandler getInstance()
	{
		return instance;
	}
	
	public InbuenerRecipeHandler()
	{
		
	}
	
	public void addRecipe(RecipieInbuenerObj obj)
	{
		recipies.add(obj);
	}
	
	public ItemStack getOutput(Item par1, int par2, Item par3, int par4, Item par5, int par6)
	{
		for(int a = 0; a < recipies.size(); a++)
		{
			if(recipies.get(a).getExtra() == par1)
			{
				if(recipies.get(a).getNumExtra() <= par2)
				{
					if(recipies.get(a).getEssence() == par3)
					{
						if(recipies.get(a).getNumEssence() <= par4)
						{
							if(recipies.get(a).getShard() == par5)
							{
								if(recipies.get(a).getNumShard() <= par6)
								{
									return recipies.get(a).output();
								}
							}
						}
					}
				}
			}
		}
		return null;
	}
}
