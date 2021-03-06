package Magecraft.Common;

import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraftforge.common.DungeonHooks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

import net.minecraft.src.Material;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.LanguageRegistry;
import Magecraft.Common.Items.Magecraft_Items;
import Magecraft.Common.TileEntity.TileEntityInbuener;
import Magecraft.Common.Blocks.BlockInbuener;
import Magecraft.Common.Blocks.BlocksFile;


@NetworkMod(clientSideRequired = true, serverSideRequired = false)
@Mod(modid = "FMC", name = "MageCraft", version = ".01 Alpha")
public class Magecraft_Main {
	
	@Instance 
	public static Magecraft_Main instance;
	
	//hardcoded id of block
	public static int BlockID = 230;
	
	public static Block blocks;
	public static Block blockInbuener;
	
	
	@SidedProxy(clientSide = "Magecraft.Common.ClientProxyMagecraft", serverSide = "Magecraft.Common.CommonProxyMagecraft")
	public static CommonProxyMagecraft proxy;
	
	
	@Init
	public void load(FMLInitializationEvent event)
	{
		proxy.registerRenderThings();
		Magecraft_Items.createInstance();
		RecipeHandler.createInstance();
		InbuenerRecipeHandler.createInstance();
		
		NetworkRegistry.instance().registerGuiHandler(this, this.proxy);
		
		blocks = new BlocksFile(BlockID, 0).setStepSound(Block.soundStoneFootstep).setHardness(3F).setResistance(1.0F).setBlockName("blocks");;
		Item.itemsList[BlockID] = new Magecraft.Common.Blocks.MetaBlocks(BlockID-256, blocks).setItemName("Blocks");
		
		blockInbuener = new BlockInbuener(231, Material.iron).setStepSound(Block.soundStoneFootstep).setHardness(3F).setResistance(1.0F).setBlockName("orbBlock");;
		GameRegistry.registerBlock(blockInbuener);
		LanguageRegistry.addName(blockInbuener, "Inbuener"); 
		
		GameRegistry.registerTileEntity(TileEntityInbuener.class,"tileEntityOrb");
		
		LanguageRegistry.instance().addStringLocalization("tile.blocks.Verinite Ore.name", "Verinite Ore");
		LanguageRegistry.instance().addStringLocalization("tile.blocks.Verinite Block.name", "Verinite Block");
		
		Magecraft_Items.getInstance().instantiateItems();
		Magecraft_Items.getInstance().nameItems();
		
		RecipeHandler.getInstance().addCraftingTableRecipes();
		RecipeHandler.getInstance().addShapelessRecipes();
		RecipeHandler.getInstance().addFurnaceRecipes();
		RecipeHandler.getInstance().addInbuenerRecipes(InbuenerRecipeHandler.getInstance());
		
		
	}
	
}
