package Magecraft.Common.Items;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;

public class VeriniteIngot extends Item
{
	
	public VeriniteIngot(int i)
	{
		super(i);
	    maxStackSize = 64;
	    this.setTabToDisplayOn(CreativeTabs.tabMaterials);
	}
	
	public String getTextureFile()
    {
		return "/MageCraft_Resources/ItemTextureSheet.png";
    }
}
