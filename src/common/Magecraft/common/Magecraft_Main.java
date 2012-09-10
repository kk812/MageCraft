package Magecraft.common;

import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraftforge.common.DungeonHooks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

import net.minecraft.src.Material;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "FMC", name = "MageCraft", version = ".01 Alpha")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class Magecraft_Main {

	public static int BlockID = 230;
	
	public static Block blocks;
	
	
	@SidedProxy(clientSide = "Magecraft.client.clientProxyMagecraft", serverSide = "Magecraft.common.commonProxyMagecraft")
	public static commonProxyMagecraft proxy;
	
	
	@Init
	public void load(FMLInitializationEvent event)
	{
		proxy.registerRenderThings();
		blocks = new Magecraft.common.Blocks.BlocksFile(BlockID, 0, Material.rock).setStepSound(Block.soundStoneFootstep).setHardness(3F).setResistance(1.0F).setBlockName("oreblock");;
		Item.itemsList[BlockID] = new Magecraft.common.Blocks.MetaBlocks(BlockID-256, blocks).setItemName("Blocks");
		
		LanguageRegistry.instance().addStringLocalization("tile.blocks.1", "block 1");
		LanguageRegistry.instance().addStringLocalization("tile.blocks.2", "block 2");
		LanguageRegistry.instance().addStringLocalization("tile.blocks.3", "block 3");
	}
	
}
