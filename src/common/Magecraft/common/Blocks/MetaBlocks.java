package Magecraft.common.Blocks;

import net.minecraft.src.Block;
import net.minecraft.src.ItemBlock;
import net.minecraft.src.ItemStack;

public class MetaBlocks extends ItemBlock{
	
	static String[] blockNames = {"Verinite Ore", "Verinite Block", "OtherBlock"};
	
	public MetaBlocks(int par1, Block block) 
	{
		super(par1);
		setHasSubtypes(true);
	}
	 
	public String getItemNameIS(ItemStack itemstack) 
	{
		String name = "";
		switch(itemstack.getItemDamage()) 
		{
			case 0: 
			{
				name = "1";
				break;
			}
			case 1: 
			{ 
				name = "2"; 
				break;
			}
			case 2:
			{
				name = "3";
			}
			default: name = "0";
		}
		return getItemName() + "." + name;
	}
	 
	public int getMetadata(int par1)
	{
		return par1;
	}
	
}
