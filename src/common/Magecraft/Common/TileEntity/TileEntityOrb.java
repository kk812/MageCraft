package Magecraft.Common.TileEntity;

import Magecraft.Common.InbuenerRecipeHandler;
import Magecraft.Common.Items.Magecraft_Items;
import net.minecraft.src.Block;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IInventory;
import net.minecraft.src.ItemStack;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.NBTTagList;
import net.minecraft.src.TileEntity;

public class TileEntityOrb extends TileEntity implements IInventory
{
	public ItemStack[] orbItemStacks;
	
	public TileEntityOrb()
	{
		orbItemStacks = new ItemStack[4];
	}
	
	@Override
	public void updateEntity()
	{
		System.out.println();
		super.updateEntity();
		if(orbItemStacks != null)
		{
			if(orbItemStacks[0] != null)
			{
				if(orbItemStacks[1] != null)
				{
					if(orbItemStacks[2] != null)
					{
						if(InbuenerRecipeHandler.getInstance().getOutput(orbItemStacks[1].getItem(), orbItemStacks[1].stackSize, orbItemStacks[2].stackSize) != null)
						{
							if(orbItemStacks[3] == null)
							{
								orbItemStacks[3] = InbuenerRecipeHandler.getInstance().getOutput(orbItemStacks[1].getItem(), orbItemStacks[1].stackSize, orbItemStacks[2].stackSize);
							}
							else
							{
								if(orbItemStacks[3].getItem() == InbuenerRecipeHandler.getInstance().getOutput(orbItemStacks[1].getItem(), orbItemStacks[1].stackSize, orbItemStacks[2].stackSize).getItem())
								{
									if(orbItemStacks[3].stackSize < 64)
									{
										orbItemStacks[3].stackSize++;
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	private void canInbue()
	{
		
	}

	@Override
    public int getSizeInventory() {
            return orbItemStacks.length;
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
            return orbItemStacks[slot];
    }
    
    @Override
    public void setInventorySlotContents(int slot, ItemStack stack) {
    		orbItemStacks[slot] = stack;
            if (stack != null && stack.stackSize > getInventoryStackLimit()) {
                    stack.stackSize = getInventoryStackLimit();
            }               
    }

    @Override
    public ItemStack decrStackSize(int slot, int amt) {
            ItemStack stack = getStackInSlot(slot);
            if (stack != null) {
                    if (stack.stackSize <= amt) {
                            setInventorySlotContents(slot, null);
                    } else {
                            stack = stack.splitStack(amt);
                            if (stack.stackSize == 0) {
                                    setInventorySlotContents(slot, null);
                            }
                    }
            }
            return stack;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int slot) {
            ItemStack stack = getStackInSlot(slot);
            if (stack != null) {
                    setInventorySlotContents(slot, null);
            }
            return stack;
    }
    
    @Override
    public int getInventoryStackLimit() {
            return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
            return worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) == this &&
            player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
    }

    @Override
    public void openChest() {}

    @Override
    public void closeChest() {}
    
    @Override
    public void readFromNBT(NBTTagCompound tagCompound) 
    {
    	super.readFromNBT(tagCompound);
        NBTTagList var2 = tagCompound.getTagList("Orb");
        this.orbItemStacks = new ItemStack[this.getSizeInventory()];
        System.out.println(var2.tagCount());
        for (int var3 = 0; var3 < var2.tagCount(); ++var3)
        {
            NBTTagCompound var4 = (NBTTagCompound)var2.tagAt(var3);
            byte var5 = var4.getByte("Slot");

            if (var5 >= 0 && var5 < this.orbItemStacks.length)
            {
                this.orbItemStacks[var5] = ItemStack.loadItemStackFromNBT(var4);
            }
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound tagCompound) {
            super.writeToNBT(tagCompound);
            NBTTagList itemList = new NBTTagList();
            
            for (int i = 0; i < orbItemStacks.length; i++) {
                    ItemStack stack = orbItemStacks[i];
                    if (stack != null) {
                            NBTTagCompound tag = new NBTTagCompound();
                            tag.setByte("Slot", (byte) i);
                            stack.writeToNBT(tag);
                            itemList.appendTag(tag);
                    }
            }
            tagCompound.setTag("Orb", itemList);
    }

	@Override
	public String getInvName() {
		return "Orb";
	}
}
