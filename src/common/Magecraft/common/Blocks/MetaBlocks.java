package Magecraft.common.Blocks;

import net.minecraft.src.ItemBlock;
import net.minecraft.src.ItemStack;

public class MetaBlocks extends ItemBlock{
	
	static String[] blockNames = {"Verinite Ore", "Verinite Block"};
	
	public MetaBlocks(int par1) {
		super(par1);
		setMaxDamage(0);
		setHasSubtypes(true);
	}
	
	@Override
	public int getMetadata(int i) 
	{
		return i;
	}
	@Override
	public String getItemNameIS(ItemStack itemstack) 
	{
		String s = new StringBuilder().append(super.getItemName()).append(".").append(blockNames[itemstack.getItemDamage()]).toString();
		return s;
	}
	
}
