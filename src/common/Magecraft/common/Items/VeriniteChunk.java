package Magecraft.Common.Items;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;

public class VeriniteChunk extends Item 
{

	public VeriniteChunk(int par1) 
	{
		super(par1);
		maxStackSize = 64;
		this.setTabToDisplayOn(CreativeTabs.tabMaterials);
	}
	
	public String getTextureFile()
    {
		return "/MageCraft_Resources/ItemTextureSheet.png";
    }
}
