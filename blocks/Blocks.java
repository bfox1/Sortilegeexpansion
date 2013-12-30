package Sortilegeexpansion.blocks;

import Sortilegeexpansion.Sortilegeexpansion;
import Sortilegeexpansion.lib.config.Names;
import Sortilegeexpansion.lib.config.ids;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockHalfSlab;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSlab;
import net.minecraftforge.common.MinecraftForge;


public class Blocks {
	/**
	 * This line of code below relates to VerbalSmeltery and all its sub classes.
	 */
	

		//Basic blocks
	public static Block verbalblock;
	
		//Special containers
	public static Block blockcontainer;

	
	public static void init() {
		
			//Basic block registration
		//verbalblock = new Verbalblock(ids.verbalblock_actual);
		//GameRegistry.registerBlock(verbalblock, Names.Verbalblock_name);
		
		//Special containers
		blockcontainer = new NewChest(ids.newchest_acutal);
		GameRegistry.registerBlock(blockcontainer, Names.Newchest_name);
		GameRegistry.registerTileEntity(chesttiny.class, "Containernewchest");
		

		
	}

	public static void addNames() {
			//Basic block Name registration
		//LanguageRegistry.addName((Block given name), ("Name of block"));

	}
	
	public static void addHarvestLevel() {
			
		//MinecraftForge.setBlockHarvestLevel((Name of block), "pickaxe", 3); //wood=0, stone=1, iron=2 diamond=3

	}
	
	public static void postInit(FMLPostInitializationEvent event)
	{

	}

}