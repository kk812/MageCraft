package Magecraft.common.Blocks;

import net.minecraft.src.Block;
import net.minecraft.src.ItemBlock;
import net.minecraft.src.ItemStack;

public class MetaBlocks extends ItemBlock{
	
	static String[] blockNames = {"Verinite Ore", "Verinite Block"};
	
	public MetaBlocks(int par1, Block block) 
	{
		super(par1);
		setHasSubtypes(true);
	}
	 
	public String getItemNameIS(ItemStack itemstack) 
	{
		String name = "";
		if(blockNames.length > itemstack.getItemDamage())
		{
			name = blockNames[itemstack.getItemDamage()];
		}
		return getItemName() + "." + name;
	}
	 
	public int getMetadata(int par1)
	{
		return par1;
	}
	
}
