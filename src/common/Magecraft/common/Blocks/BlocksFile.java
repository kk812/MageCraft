package Magecraft.common.Blocks;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;

public class BlocksFile extends Block{

	public BlocksFile(int par1, int par2, Material par3Material) 
	{
		super(par1, par2, par3Material);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setRequiresSelfNotify();
	}
	
	public int getBlockTextureFromSideAndMetadata(int par1, int par2)
	{
		switch(par2)
		{
			case 0:
				return 0;
			case 1:
				return 1;
			case 2:
				return 2;
		}
		return 0;
	}
	
	public String getTextureFile()
	{
		return "/MageCraft_Resources/BlockTextureSheet.png";
	}
	
	public int idDropped(int par1, Random par2Random, int par3)
	{
		switch(par1)
		{
			case 0:
				return 1;
			case 1:
				return 2;
			case 2:
				return 3;
		}
		return 0;
	}
	
	public int qunatityDropped(Random par1Random)
	{
		return 1;
	}
	
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int par1, CreativeTabs par2VreativeTabs, List par3List)
	{
		for(int var4 = 0; var4 < 3; var4++)
		{
			par3List.add(new ItemStack(par1, 1, var4));
		}
	}
}