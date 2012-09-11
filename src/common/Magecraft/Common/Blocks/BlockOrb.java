package Magecraft.Common.Blocks;

import net.minecraft.src.BlockContainer;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Material;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;

public class BlockOrb extends BlockContainer{

	public BlockOrb(int par1, Material par2Material) {
		super(par1, par2Material);
        this.setBlockBounds(0.3F, 0.3F, 0.3F, 0.7F, 0.7F, 0.7F);
        this.setLightOpacity(10);
        this.setCreativeTab(CreativeTabs.tabDeco);
	}

	@Override
	public boolean renderAsNormalBlock()
    {
        return false;
    }
	
	@Override
	public boolean isOpaqueCube()
    {
        return false;
    }
	
	@Override
	public int getBlockTextureFromSideAndMetadata(int par1, int par2)
    {
        return this.getBlockTextureFromSide(par1);
    }
	
	@Override
	public TileEntity createNewTileEntity(World var1) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
