package Magecraft.Common.Blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Magecraft.Common.Magecraft_Main;
import Magecraft.Common.Items.Magecraft_Items;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlocksFile extends Block{
	
	
	//should not be needed: public int ID = 0;
	
	public BlocksFile(int par1, int par2) 
	{
		super(par1, par2, Material.rock);
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
		}
		return 0;
	}
	
	public String getTextureFile()
	{
		return "/MageCraft_Resources/BlockTextureSheet.png";
	}
	
	@Override
	public ArrayList<ItemStack> getBlockDropped(World world, int x, int y, int z, int metadata, int fortune)
    {
        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
        
        if(metadata == 0)
        {
        	if(world.rand.nextInt(10)+1> 3)
        	{
        		ret.add(new ItemStack(Magecraft_Items.getInstance().veriniteEssence, (world.rand.nextInt(4)+1)));
        	}
        	else
        	{
        		ret.add(new ItemStack(Magecraft_Items.getInstance().veriniteChunk, 1));
        	}
        }
        else if(metadata == 1)
        {
        	ret.add(new ItemStack(Magecraft_Main.blocks, 1, 1));
        }
        
        return ret;
    }
	
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int par1, CreativeTabs par2VreativeTabs, List par3List)
	{
		for(int var4 = 0; var4 < 2; var4++)
		{
			par3List.add(new ItemStack(par1, 1, var4));
		}
	}
}