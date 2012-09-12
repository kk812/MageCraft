package Magecraft.Common.Containers;

import Magecraft.Common.TileEntity.TileEntityOrb;
import net.minecraft.src.Container;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.InventoryPlayer;

public class ContainerOrb extends Container{

	public ContainerOrb(InventoryPlayer par1InventoryPlayer, TileEntityOrb par2TileEntityIronFurnace)
    {
        
    }
	
	@Override
	public boolean canInteractWith(EntityPlayer var1) 
	{
		return true;
	}

}
