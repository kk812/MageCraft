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

public class TileEntityInbuener extends TileEntity implements IInventory
{
	private boolean inbuenerCooking = false;
	private int tickCounter = 0;
	
	public ItemStack[] orbItemStacks;
	
	
	
	public TileEntityInbuener()
	{
		orbItemStacks = new ItemStack[4];
	}
	
	@Override
	public void updateEntity()
	{
		int one;
		int two;
		int three;
		super.updateEntity();
		System.out.println("Ticks" + tickCounter);
		if(canInbue())
		{
			if(this.inbuenerCooking == false)
			{
				this.inbuenerCooking = true;
				tickCounter = 0;
			}
			else
			{
				tickCounter++;
				if(tickCounter == 200)
				{
					this.inbuenerCooking = false;
					if(orbItemStacks[3] == null)
					{
						orbItemStacks[3] = InbuenerRecipeHandler.getInstance().getOutput(orbItemStacks[0], orbItemStacks[1], orbItemStacks[2]);
					}
					else
					{
						orbItemStacks[3].stackSize += InbuenerRecipeHandler.getInstance().getOutputNum(orbItemStacks[0], orbItemStacks[1], orbItemStacks[2]);
					}
					//cache amounts for each slot to remove.
					one = InbuenerRecipeHandler.getInstance().getShardNum(orbItemStacks[0], orbItemStacks[1], orbItemStacks[2]);
					two = InbuenerRecipeHandler.getInstance().getExtraNum(orbItemStacks[0], orbItemStacks[1], orbItemStacks[2]);
					three = InbuenerRecipeHandler.getInstance().getEssenceNum(orbItemStacks[0], orbItemStacks[1], orbItemStacks[2]);
					
					if(orbItemStacks[0].stackSize > one)
					{
						orbItemStacks[0].stackSize = orbItemStacks[0].stackSize - one;
					}
					else
					{
						orbItemStacks[0] = null;
					}
					if(orbItemStacks[1].stackSize > two)
					{
						orbItemStacks[1].stackSize = orbItemStacks[1].stackSize - two;
					}
					else
					{
						orbItemStacks[1] = null;
					}
					if(orbItemStacks[2].stackSize > three)
					{
						orbItemStacks[2].stackSize = orbItemStacks[2].stackSize - three;
					}
					else
					{
						orbItemStacks[2] = null;
					}
				}
			}
		}
	}
	
	private boolean canInbue()
	{
		ItemStack container;
		if(orbItemStacks != null)
		{
			if(orbItemStacks[0] != null && orbItemStacks[1] != null && orbItemStacks[2] != null)
			{
				container = InbuenerRecipeHandler.getInstance().getOutput(orbItemStacks[0], orbItemStacks[1], orbItemStacks[2]);
				if(container != null)
				{
					if(orbItemStacks[3] != null)
					{
						if(orbItemStacks[3].getItem() == container.getItem())
						{
							if(container.getItem().getItemStackLimit() >=  orbItemStacks[3].stackSize + InbuenerRecipeHandler.getInstance().getOutputNum(orbItemStacks[0], orbItemStacks[1], orbItemStacks[2]))
							{
								return true;
							}
							else
							{
								return false;
							}
						}
						else
						{
							return false;
						}
					}
					else
					{
						return true;
					}
				}
				else
				{
					return false;
				}
			}
		}
		return false;
	}

	public int getPercentDone()
	{
		return 0;
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
