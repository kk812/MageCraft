package Magecraft.Common.GUI;

import org.lwjgl.opengl.GL11;

import Magecraft.Common.Containers.ContainerInbuener;
import Magecraft.Common.TileEntity.TileEntityInbuener;

import net.minecraft.src.Container;
import net.minecraft.src.GuiContainer;
import net.minecraft.src.InventoryPlayer;

public class GuiInbuener extends GuiContainer
{

	public GuiInbuener(InventoryPlayer player, TileEntityInbuener tileEntity) 
	{
		super(new ContainerInbuener(player, tileEntity));
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) 
	{
		int i = mc.renderEngine.getTexture("/MageCraft_Resources/Gui's/InbuenerGUI.png");
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
		mc.renderEngine.bindTexture(i);
		int j = (width - xSize) / 2;
		int k = (height - ySize) / 2;
		drawTexturedModalRect(j, k, 0, 0, xSize, ySize);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(){
		fontRenderer.drawString("Inbuener", 10, 10, 0x404040);
	}

}
