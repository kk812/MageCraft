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
import Magecraft.common.Items.Magecraft_Items;
import Magecraft.common.Blocks.BlocksFile;

@Mod(modid = "FMC", name = "MageCraft", version = ".01 Alpha")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class Magecraft_Main {

	public static int BlockID = 230;
	
	public static Block blocks;
	
	
	@SidedProxy(clientSide = "Magecraft.client.ClientProxyMagecraft", serverSide = "Magecraft.common.CommonProxyMagecraft")
	public static CommonProxyMagecraft proxy;
	
	
	@Init
	public void load(FMLInitializationEvent event)
	{
		proxy.registerRenderThings();
		Magecraft_Items.createInstance();
		RecipeHandler.createInstance();
		
		
		blocks = new BlocksFile(BlockID, 0).setStepSound(Block.soundStoneFootstep).setHardness(3F).setResistance(1.0F).setBlockName("blocks");;
		Item.itemsList[BlockID] = new Magecraft.common.Blocks.MetaBlocks(BlockID-256, blocks).setItemName("Blocks");
		
		LanguageRegistry.instance().addStringLocalization("tile.blocks.Verinite Ore.name", "Verinite Ore");
		LanguageRegistry.instance().addStringLocalization("tile.blocks.Verinite Block.name", "Verinite Block");
		
		Magecraft_Items.getInstance().instantiateItems();
		Magecraft_Items.getInstance().nameItems();
		
		RecipeHandler.getInstance().addCraftingTableRecipes();
		RecipeHandler.getInstance().addShapelessRecipes();
		RecipeHandler.getInstance().addFurnaceRecipes();
		
	}
	
}
