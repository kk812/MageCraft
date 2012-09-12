package Magecraft.Common.GUI;

import org.lwjgl.opengl.GL11;

import Magecraft.Common.Containers.ContainerOrb;
import Magecraft.Common.TileEntity.TileEntityOrb;

import net.minecraft.src.Container;
import net.minecraft.src.GuiContainer;
import net.minecraft.src.InventoryPlayer;

public class GuiOrb extends GuiContainer
{

	public GuiOrb(InventoryPlayer player, TileEntityOrb tileEntity) 
	{
		super(new ContainerOrb(player, tileEntity));
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) 
	{
		int i = mc.renderEngine.getTexture("/gui/furnace.png");
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
		mc.renderEngine.bindTexture(i);
		int j = (width - xSize) / 2;
		int k = (height - ySize) / 2;
		drawTexturedModalRect(j, k, 0, 0, xSize, ySize);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(){
		fontRenderer.drawString("Orb", 60, 6, 0x404040);
	}

}
