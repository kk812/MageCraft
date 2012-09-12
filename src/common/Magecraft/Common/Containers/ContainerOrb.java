package Magecraft.Common.Containers;

import Magecraft.Common.GUI.Slots.SlotOrb;
import Magecraft.Common.TileEntity.TileEntityOrb;
import net.minecraft.src.Container;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.InventoryPlayer;
import net.minecraft.src.Slot;
import net.minecraft.src.TileEntity;


public class ContainerOrb extends Container{

	public ContainerOrb(InventoryPlayer par1InventoryPlayer, TileEntityOrb te)
    {
		this.addSlotToContainer(new Slot(par1InventoryPlayer, 0, 56, 17));
        this.addSlotToContainer(new Slot(par1InventoryPlayer, 1, 56, 53));
        this.addSlotToContainer(new SlotOrb(par1InventoryPlayer.player, par1InventoryPlayer, 2, 116, 35));
    }
	
	@Override
	public boolean canInteractWith(EntityPlayer var1) 
	{
		return true;
	}
}
