package Magecraft.Common.Blocks;

import java.util.Random;

import Magecraft.Common.Magecraft_Main;
import Magecraft.Common.TileEntity.TileEntityInbuener;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import net.minecraft.src.Block;
import net.minecraft.src.BlockContainer;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Material;
import net.minecraft.src.TileEntity;
import net.minecraft.src.TileEntityEnchantmentTable;
import net.minecraft.src.World;

public class BlockInbuener extends BlockContainer{

	public BlockInbuener(int par1, Material par2Material) 
	{
		super(par1, par2Material);
		super.blockIndexInTexture = 2;
        this.setLightOpacity(10);
        this.setCreativeTab(CreativeTabs.tabDeco);
	}
	
	@Override
	public boolean renderAsNormalBlock()
    {
        return true;
    }
	
	@Override
	public boolean isOpaqueCube()
    {
        return true;
    }
	
	@Override
	public String getTextureFile()
    {
            return "/MageCraft_Resources/BlockTextureSheet.png";
    }
	
	@Override
	public TileEntity createNewTileEntity(World var1) 
	{
		return new TileEntityInbuener();
	}
	
	/**
     * Called upon block activation (right click on the block.)
     */
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
        if (par1World.isRemote)
        {
            return true;
        }
        else
        {
        	par5EntityPlayer.openGui(Magecraft_Main.instance, 0, par1World, par2, par3, par4);
    		return true;
        }
    }
    
    @SideOnly(Side.CLIENT)

    /**
     * A randomly called display update to be able to add particles or other items for display
     */
    public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        super.randomDisplayTick(par1World, par2, par3, par4, par5Random);
    }
}
