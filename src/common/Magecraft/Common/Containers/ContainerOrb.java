package Magecraft.Common.Containers;

import Magecraft.Common.GUI.Slots.SlotOrb;
import Magecraft.Common.TileEntity.TileEntityOrb;
import net.minecraft.src.*;

public class ContainerOrb extends Container{

	public ContainerOrb(InventoryPlayer par1InventoryPlayer, TileEntityOrb par2TileEntityOrb)
    {
		this.addSlotToContainer(new Slot(par2TileEntityOrb, 0, 56, 17));
        this.addSlotToContainer(new Slot(par2TileEntityOrb, 1, 56, 53));
        this.addSlotToContainer(new SlotOrb(par1InventoryPlayer, par2TileEntityOrb, 2, 116, 35));
    }
	
	@Override
	public boolean canInteractWith(EntityPlayer var1) 
	{
		return true;
	}

}
