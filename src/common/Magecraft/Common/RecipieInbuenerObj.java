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
	
	private Item outputItem;
	private int outputNum;
	
	public RecipieInbuenerObj(ItemStack par1, ItemStack par2, ItemStack par3, Item par4, int par5)
	{
		shard = par1.getItem();
		numShard = par1.stackSize;
		extra = par2.getItem();
		numExtra = par2.stackSize;
		essence = par3.getItem();
		numEssence = par3.stackSize;
		outputItem = par4;
		outputNum = par5;
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
	
	public Item output()
	{
		return outputItem;
	}
	
	public int outputNum()
	{
		return outputNum;
	}
}
