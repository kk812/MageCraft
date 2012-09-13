package Magecraft.Common;

import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;

public class RecipieInbuenerObj 
{
	private Item extra;
	private int numExtra;
	private int numEssence;
	private ItemStack output;
	
	public RecipieInbuenerObj(Item par1, int par2, int par3, ItemStack par4)
	{
		extra = par1;
		numExtra = par2;
		numEssence = par3;
		output = par4;
	}
	
	public Item getExtra()
	{
		return extra;
	}
	
	public int getNumExtra()
	{
		return numExtra;
	}
	
	public int getNumEssence()
	{
		return numEssence;
	}
	
	public ItemStack output()
	{
		return output;
	}
}
