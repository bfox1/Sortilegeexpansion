package Sortilegeexpansion;

import java.util.logging.Level;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSlab;
import Sortilegeexpansion.oregen.Worldgenore;
import Sortilegeexpansion.proxies.CommonProxy;
import Sortilegeexpansion.items.Items;
import Sortilegeexpansion.blocks.Blocks;
import Sortilegeexpansion.lib.LogHelper;
import Sortilegeexpansion.lib.ModInfo;
import Sortilegeexpansion.lib.Sortilegeexpansiontab;
import Sortilegeexpansion.lib.config.ConfigHandler;
import Sortilegeexpansion.lib.config.Recipes;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

/**
 * 
 * This is below is linked to modID. Basic requirements.
 * 
 */

@Mod(modid = ModInfo.ID, name = ModInfo.NAME, version = ModInfo.VERSION)
@NetworkMod(channels = { ModInfo.CHANNEL }, clientSideRequired = true, serverSideRequired = true)
public class Sortilegeexpansion {

	@SidedProxy(clientSide = ModInfo.PROXY_LOCATION + ".ClientProxy", serverSide = ModInfo.PROXY_LOCATION
			+ ".CommonProxy")
	public static CommonProxy proxy;
	


	public static CreativeTabs sortilegeexpansion = new Sortilegeexpansiontab(
			CreativeTabs.getNextID(), ModInfo.NAME);
	
	public static CreativeTabs sortilegeexptools = new SortilegeexpansionToolsTab(
			CreativeTabs.getNextID(), ModInfo.CREATIVETOOL);

	/**
	 * 
	 * This is pre-load
	 */
	@EventHandler
	public static void preInit(FMLPreInitializationEvent event) {
		LogHelper.init();
		ConfigHandler.init(event.getSuggestedConfigurationFile());
		// Adds Sounds and renders to minecraft
		proxy.initRenderers();
		proxy.initSounds();
		LogHelper.log(Level.INFO, "Preparing Blocks, Items, Recipes");
		// Loads items details BEFORE statup.
		Items.init();
		Blocks.init();
		Recipes.init();
		Recipes.addSmeltingRecipes();
		LogHelper.log(Level.INFO, "Blocks, Items, Recipes have been loaded");
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event)
	{
        Blocks.addHarvestLevel();
	}

	// This happens DURING the startup
	@EventHandler
	public static void init(FMLInitializationEvent event) {
		LanguageRegistry.instance().addStringLocalization(
				"itemGroup." + ModInfo.NAME, "en_US", ModInfo.NAME);
		LanguageRegistry.instance().addStringLocalization(
				"itemGroup." + ModInfo.CREATIVETOOL, "en_US", ModInfo.CREATIVETOOL);
		// This log will log in Console of when stuff takes place.
		LogHelper.log(Level.INFO, "Adding Names of Blocks, Items");
		Items.addNames();
		Blocks.addNames();
		//Blocks.addHarvestLevel();
		LogHelper.log(Level.INFO, "Names of Items, Blocks added");
		//Oregeneration.regWorld();
		GameRegistry.registerWorldGenerator(new Worldgenore());



	}

	// And as of this happens AFTER the startup
	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) {
		Blocks.postInit(event);
	}

}