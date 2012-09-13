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
	
	public ItemStack getOutput(ItemStack par1, ItemStack par2, ItemStack par3)
	{
		for(int a = 0; a < recipies.size(); a++)
		{
			if(recipies.get(a).getShard() == par1.getItem() && recipies.get(a).getExtra() == par2.getItem() && recipies.get(a).getEssence() == par3.getItem())
			{
				if(recipies.get(a).getNumShard() <= par1.stackSize && recipies.get(a).getNumExtra() <= par2.stackSize && recipies.get(a).getNumEssence() <= par3.stackSize)
				{
					return recipies.get(a).output();
				}
			}
		}
		return null;
	}
	
	public int getOutputNum(ItemStack par1, ItemStack par2, ItemStack par3)
	{
		for(int a = 0; a < recipies.size(); a++)
		{
			if(recipies.get(a).getShard() == par1.getItem() && recipies.get(a).getExtra() == par2.getItem() && recipies.get(a).getEssence() == par3.getItem())
			{
				if(recipies.get(a).getNumShard() <= par1.stackSize && recipies.get(a).getNumExtra() <= par2.stackSize && recipies.get(a).getNumEssence() <= par3.stackSize)
				{
					return recipies.get(a).output().stackSize;
				}
			}
		}
		return 0;
	}
}
