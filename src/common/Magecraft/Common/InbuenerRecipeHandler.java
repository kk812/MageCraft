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
		if(par1 != null && par2 != null && par3 != null)
		{
			for(int a = 0; a < recipies.size(); a++)
			{
				if(recipies.get(a).getShard() == par1.getItem() && recipies.get(a).getExtra() == par2.getItem() && recipies.get(a).getEssence() == par3.getItem())
				{
					if(recipies.get(a).getNumShard() <= par1.stackSize && recipies.get(a).getNumExtra() <= par2.stackSize && recipies.get(a).getNumEssence() <= par3.stackSize)
					{
						return new ItemStack(recipies.get(a).output(), recipies.get(a).outputNum());
					}
				}
			}
		}
		return null;
	}
	
	public int getOutputNum(ItemStack par1, ItemStack par2, ItemStack par3)
	{
		if(par1 != null && par2 != null && par3 != null)
		{
			for(int a = 0; a < recipies.size(); a++)
			{
				if(recipies.get(a).getShard() == par1.getItem() && recipies.get(a).getExtra() == par2.getItem() && recipies.get(a).getEssence() == par3.getItem())
				{
					if(recipies.get(a).getNumShard() <= par1.stackSize && recipies.get(a).getNumExtra() <= par2.stackSize && recipies.get(a).getNumEssence() <= par3.stackSize)
					{
						return recipies.get(a).outputNum();
					}
				}
			}
		}
		return 0;
	}
	
	public ItemStack getShard(ItemStack par1, ItemStack par2, ItemStack par3)
	{
		if(par1 != null && par2 != null && par3 != null)
		{
			for(int a = 0; a < recipies.size(); a++)
			{
				if(recipies.get(a).getShard() == par1.getItem() && recipies.get(a).getExtra() == par2.getItem() && recipies.get(a).getEssence() == par3.getItem())
				{
					if(recipies.get(a).getNumShard() <= par1.stackSize && recipies.get(a).getNumExtra() <= par2.stackSize && recipies.get(a).getNumEssence() <= par3.stackSize)
					{
						return new ItemStack(recipies.get(a).getShard(), recipies.get(a).getNumShard());
					}
				}
			}
		}
		return null;
	}
	
	public int getShardNum(ItemStack par1, ItemStack par2, ItemStack par3)
	{
		if(par1 != null && par2 != null && par3 != null)
		{
			for(int a = 0; a < recipies.size(); a++)
			{
				if(recipies.get(a).getShard() == par1.getItem() && recipies.get(a).getExtra() == par2.getItem() && recipies.get(a).getEssence() == par3.getItem())
				{
					if(recipies.get(a).getNumShard() <= par1.stackSize && recipies.get(a).getNumExtra() <= par2.stackSize && recipies.get(a).getNumEssence() <= par3.stackSize)
					{
						return recipies.get(a).getNumShard();
					}
				}
			}
		}
		return 0;
	}
	
	public ItemStack getExtra(ItemStack par1, ItemStack par2, ItemStack par3)
	{
		if(par1 != null && par2 != null && par3 != null)
		{
			for(int a = 0; a < recipies.size(); a++)
			{
				if(recipies.get(a).getShard() == par1.getItem() && recipies.get(a).getExtra() == par2.getItem() && recipies.get(a).getEssence() == par3.getItem())
				{
					if(recipies.get(a).getNumShard() <= par1.stackSize && recipies.get(a).getNumExtra() <= par2.stackSize && recipies.get(a).getNumEssence() <= par3.stackSize)
					{
						return new ItemStack(recipies.get(a).getExtra(), recipies.get(a).getNumExtra());
					}
				}
			}
		}
		return null;
	}
	
	public int getExtraNum(ItemStack par1, ItemStack par2, ItemStack par3)
	{
		if(par1 != null && par2 != null && par3 != null)
		{
			for(int a = 0; a < recipies.size(); a++)
			{	
				if(recipies.get(a).getShard() == par1.getItem() && recipies.get(a).getExtra() == par2.getItem() && recipies.get(a).getEssence() == par3.getItem())
				{
					if(recipies.get(a).getNumShard() <= par1.stackSize && recipies.get(a).getNumExtra() <= par2.stackSize && recipies.get(a).getNumEssence() <= par3.stackSize)
					{
						return recipies.get(a).getNumExtra();
					}
				}
			}
		}
		return 0;
	}
	
	public ItemStack getEssence(ItemStack par1, ItemStack par2, ItemStack par3)
	{
		if(par1 != null && par2 != null && par3 != null)
		{
			for(int a = 0; a < recipies.size(); a++)
			{
				if(recipies.get(a).getShard() == par1.getItem() && recipies.get(a).getExtra() == par2.getItem() && recipies.get(a).getEssence() == par3.getItem())
				{
					if(recipies.get(a).getNumShard() <= par1.stackSize && recipies.get(a).getNumExtra() <= par2.stackSize && recipies.get(a).getNumEssence() <= par3.stackSize)
					{
						return new ItemStack(recipies.get(a).getEssence(), recipies.get(a).getNumEssence());
					}
				}
			}
		}
		return null;
	}
	
	public int getEssenceNum(ItemStack par1, ItemStack par2, ItemStack par3)
	{
		if(par1 != null && par2 != null && par3 != null)
		{
			for(int a = 0; a < recipies.size(); a++)
			{
				if(recipies.get(a).getShard() == par1.getItem() && recipies.get(a).getExtra() == par2.getItem() && recipies.get(a).getEssence() == par3.getItem())
				{
					if(recipies.get(a).getNumShard() <= par1.stackSize && recipies.get(a).getNumExtra() <= par2.stackSize && recipies.get(a).getNumEssence() <= par3.stackSize)
					{
						return recipies.get(a).getNumEssence();
					}
				}
			}
		}
		return 0;
	}
}
