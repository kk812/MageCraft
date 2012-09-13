package Magecraft.Common;

import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;

public class RecipieInbuenerObj 
{
	private Item extra;
	private int numExtra;
	private Item essence;
	private int numEssence;
	private Item shard;
	private int numShard;
	
	private ItemStack output;
	
	public RecipieInbuenerObj(Item par1, int par2, Item par3, int par4, Item par5, int par6, ItemStack par7)
	{
		extra = par1;
		numExtra = par2;
		essence = par3;
		numEssence = par4;
		shard = par5;
		numShard = par6;
		output = par7;
	}
	
	public Item getExtra()
	{
		return extra;
	}
	
	public int getNumExtra()
	{
		return numExtra;
	}
	
	public Item getEssence()
	{
		return essence;
	}
	
	public int getNumEssence()
	{
		return numEssence;
	}
	
	public Item getShard()
	{
		return shard;
	}
	
	public int getNumShard()
	{
		return numShard;
	}
	
	public ItemStack output()
	{
		return output;
	}
}
