package Magecraft.common.Items;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;

public class VeriniteEssence extends Item
{
	public VeriniteEssence(int par1) 
	{
		super(par1);
		this.setTabToDisplayOn(CreativeTabs.tabMaterials);
	}
	
	public String getTextureFile()
    {
		return "/MageCraft_Resources/ItemTextureSheet.png";
    }
}
