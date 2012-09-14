package Magecraft.Common.Containers;

import Magecraft.Common.GUI.Slots.SlotInbuener;
import Magecraft.Common.TileEntity.TileEntityInbuener;
import net.minecraft.src.Container;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.InventoryPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Slot;
import net.minecraft.src.TileEntity;


public class ContainerInbuener extends Container{

	public ContainerInbuener(InventoryPlayer par1InventoryPlayer, TileEntityInbuener te)
    {
		this.addSlotToContainer(new Slot(te, 0, 80, 13));
        this.addSlotToContainer(new Slot(te, 1, 44, 51));
        this.addSlotToContainer(new Slot(te, 2, 116, 51));
        this.addSlotToContainer(new SlotInbuener(par1InventoryPlayer.player, te, 3, 80, 51));
        
        for (int var3 = 0; var3 < 3; ++var3)
        {
            for (int var4 = 0; var4 < 9; ++var4)
            {
                this.addSlotToContainer(new Slot(par1InventoryPlayer, var4 + var3 * 9 + 9, 8 + var4 * 18, 84 + var3 * 18));
            }
        }

        for (int var3 = 0; var3 < 9; ++var3)
        {
            this.addSlotToContainer(new Slot(par1InventoryPlayer, var3, 8 + var3 * 18, 142));
        }
    }
	
	@Override
	public boolean canInteractWith(EntityPlayer var1) 
	{
		return true;
	}
	
	@Override
    public ItemStack transferStackInSlot(int slot) {
            ItemStack stack = null;
            Slot slotObject = (Slot) inventorySlots.get(slot);

            //null checks and checks if the item can be stacked (maxStackSize > 1)
            if (slotObject != null && slotObject.getHasStack()) {
                    ItemStack stackInSlot = slotObject.getStack();
                    stack = stackInSlot.copy();

                    //merges the item into player inventory since its in the tileEntity
                    if (slot == 0) 
                    {
                            if (!mergeItemStack(stackInSlot, 3, inventorySlots.size(), true)) {
                                    return null;
                            }
                    //places it into the tileEntity is possible since its in the player inventory
                    } 
                    else if (!mergeItemStack(stackInSlot, 0, 1, false)) 
                    {
                            return null;
                    }

                    if (stackInSlot.stackSize == 0) 
                    {
                            slotObject.putStack(null);
                    } else 
                    {
                            slotObject.onSlotChanged();
                    }
            }

            return stack;
    }
}
