package Sortilegeexpansion.blocks;

import Sortilegeexpansion.Sortilegeexpansion;
import Sortilegeexpansion.lib.ModInfo;
import Sortilegeexpansion.lib.config.Names;
import Sortilegeexpansion.lib.config.ids;
import Sortilegeexpansion.liquid.rawLiquidEssenceFlowing;
import Sortilegeexpansion.liquid.rawLiquidEssenceStill;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlowing;
import net.minecraft.block.BlockFluid;
import net.minecraft.block.BlockHalfSlab;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSlab;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;


public class Blocks {
	/**
	 * This line of code below relates to VerbalSmeltery and all its sub classes.
	 */
	

		//Basic blocks
	public static Block verbalblock;
	
		//Special containers
	public static Block blockcontainer;
	
		//Decayer
	public static Block blockDecayerIdle;
	public static Block blockDecayerActive;
	
		//Liquid blocks
	public static Block rawliquidessenceflowing;
	public static Block rawliquidessencestill;
	
	public static Block blockrawliquidessence;
	
	public static Material materialrawliquidessence;
	
	public static Fluid fluidrawliquidessence;
	


	


	
	public static void init() {
		
			//Basic block registration
		//verbalblock = new Verbalblock(ids.verbalblock_actual);
		//GameRegistry.registerBlock(verbalblock, Names.Verbalblock_name);
		
		//Special containers
		blockcontainer = new MiniChest(ids.newchest_acutal);
		GameRegistry.registerBlock(blockcontainer, Names.Newchest_name);
		GameRegistry.registerTileEntity(TileEntityMiniChest.class, "Containernewchest");
		
		//decayer
		blockDecayerIdle = new BlockDecayer(ids.blockDecayerIdle_actual, false).setUnlocalizedName(Names.blockDecayerIdle_name).setHardness(3.7F).setCreativeTab(Sortilegeexpansion.sortilegeexpansion);
		blockDecayerActive = new BlockDecayer(ids.blockDecayerActive_actual, true).setUnlocalizedName(Names.blockDecayerActive_name).setHardness(3.7F).setLightValue(0.9F);
		GameRegistry.registerBlock(blockDecayerIdle, Names.blockDecayerIdle_name);
		GameRegistry.registerBlock(blockDecayerActive, Names.blockDecayerActive_name);
		GameRegistry.registerTileEntity(TileEntityDecayer.class, "Decayer");
		LanguageRegistry.instance().addStringLocalization("container.decayer", "Decayer");
		
		//Liquids
		rawliquidessenceflowing = new rawLiquidEssenceFlowing(ids.rawliquidessenceflowing_actual).setUnlocalizedName(Names.rawliquidessenceflowing_unlocalizedName).setCreativeTab(Sortilegeexpansion.sortilegeexpansion);
		rawliquidessencestill = new rawLiquidEssenceStill(ids.rawliquidessencestill_actual).setUnlocalizedName(Names.rawliquidessencestill_unlocalizedName);
		GameRegistry.registerBlock(rawliquidessenceflowing, Names.rawliquidessenceflowing_name);
		GameRegistry.registerBlock(rawliquidessencestill, Names.rawliquidessencestill_name);
		
		fluidrawliquidessence = new Fluid("fluid").setBlockID(ids.rawliquidessence_actual);
		FluidRegistry.registerFluid(fluidrawliquidessence);
		
		//Material
		//materialrawliquidessence = new Material(MapColor.grassColor);
		
		
		//Liquid Blocks
		//blockrawliquidessence = new BlockRawLiquidEssence(ids.rawliquidessence_actual).setUnlocalizedName(Names.rawliquidessence_unlocalizedName).setTextureName(ModInfo.ID.toLowerCase() + ":" + "raw_liquid_essence");
		//GameRegistry.registerBlock(blockrawliquidessence, Names.rawliquidesence_name);
		
	}

	public static void addNames() {
			//Basic block Name registration
		//LanguageRegistry.addName((Block given name), ("Name of block"));
		LanguageRegistry.addName(blockDecayerIdle, Names.blockDecayerActive_name);
		LanguageRegistry.addName(blockDecayerIdle, Names.blockDecayerIdle_name);
		LanguageRegistry.addName(rawliquidessenceflowing, Names.rawliquidessenceflowing_name);
		LanguageRegistry.addName(rawliquidessencestill, Names.rawliquidessencestill_name);
		//LanguageRegistry.addName(blockrawliquidessence, Names.rawliquidesence_name);

	}
	
	public static void addHarvestLevel() {
			
		//MinecraftForge.setBlockHarvestLevel((Name of block), "pickaxe", 3); //wood=0, stone=1, iron=2 diamond=3

	}
	
	public static void postInit(FMLPostInitializationEvent event)
	{

	}

}