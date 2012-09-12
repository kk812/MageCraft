package Magecraft.Common;

import Magecraft.Common.Containers.ContainerOrb;
import Magecraft.Common.GUI.GuiOrb;
import Magecraft.Common.TileEntity.TileEntityOrb;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxyMagecraft implements IGuiHandler
{
	//not used for much as of now.
	public void registerRenderThings()
    {
        
    }

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);

		if (tileEntity != null)
        {
			return new ContainerOrb(player.inventory, ((TileEntityOrb)tileEntity));
        }
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);

		if (tileEntity != null)
        {
			return new GuiOrb(player.inventory, ((TileEntityOrb)tileEntity));
        }

		return null;
	}
}
