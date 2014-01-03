package Sortilegeexpansion.lib.config;

import java.io.File;

import net.minecraftforge.common.Configuration;

public class ConfigHandler {

	public static void init(File configFile) {
		Configuration config = new Configuration(configFile);

		// To categories the configs
		final String BOOLEANS = config.CATEGORY_GENERAL
				+ config.CATEGORY_SPLITTER + "booleans";

		config.load();

		/**
		// BlocksConfig
		ids.verbalblock_actual = config.getBlock(config.CATEGORY_BLOCK,
				Names.Verbalblock_name, ids.verbalblock_defualt).getInt();
		



		// ItemsConfig
		ids.verbal_actual = config.getItem(config.CATEGORY_ITEM,
				Names.Verbal_name, ids.verbal_default).getInt() - 256;

		
			//ItemsConfig for Tools
		ids.omnitool_actual = config.getItem(config.CATEGORY_ITEM,
				Names.Omnitool_name, ids.omnitool_default).getInt() - 256;
*/
		
		
			//Items
		
		ids.rawessencechunk_actual = config.getItem(config.CATEGORY_ITEM,
				Names.rawessencechunk_name, ids.rawessencechunk_default).getInt();
		
		ids.decayedironingot_actual = config.getItem(config.CATEGORY_ITEM,
				Names.decayedironingot_name, ids.decayedironingot_default).getInt();
		
		ids.decayedgoldingot_actual = config.getItem(config.CATEGORY_ITEM,
				Names.decayedgoldingot_name, ids.decayedgoldingot_default).getInt();
		
		ids.decayedcoalchunk_actual = config.getItem(config.CATEGORY_ITEM,
				Names.decayedcoalchunk_name, ids.decayedcoalchunk_default).getInt();
		
		ids.decayedlapischunk_actual = config.getItem(config.CATEGORY_ITEM,
				Names.decayedlapischunk_name, ids.decayedlapischunk_default).getInt();
		
		ids.decayeddiamondshard_actual = config.getItem(config.CATEGORY_ITEM,
				Names.decayeddiamondchunk_name, ids.decayeddiamondshard_default).getInt();
		
		ids.decayedcopperingot_actual = config.getItem(config.CATEGORY_ITEM,
				Names.decayedcopperingot_name, ids.decayedcopperingot_default).getInt();
		
		ids.decayedcopperingot_actual = config.getItem(config.CATEGORY_ITEM,
				Names.decayedcopperingot_name, ids.decayedcopperingot_default).getInt();
		
		ids.decayedtiningot_actual = config.getItem(config.CATEGORY_ITEM,
				Names.decayedtiningot_name, ids.decayedtiningot_default).getInt();
		
		ids.decayedsilveringot_actual = config.getItem(config.CATEGORY_ITEM,
				Names.decayedsilveringot_name, ids.decayedsilveringot_default).getInt();
		
		ids.decayedleadingot_actual = config.getItem(config.CATEGORY_ITEM,
				Names.decayedleadingot_name, ids.decayedleadingot_default).getInt();
		
		ids.lambentessence_actual = config.getItem(config.CATEGORY_ITEM,
				Names.lambentessence_name, ids.lambentessence_default).getInt();
			//Blocks
		ids.newchest_acutal = config.getBlock(config.CATEGORY_BLOCK,
				Names.Newchest_name, ids.newchest_default).getInt();
		
		ids.blockDecayerActive_actual = config.getBlock(config.CATEGORY_BLOCK,
				Names.blockDecayerActive_name, ids.blockDecayerActive_default).getInt();
		
		ids.blockDecayerIdle_actual = config.getBlock(config.CATEGORY_BLOCK,
				Names.blockDecayerIdle_name, ids.blockDecayerIdle_default).getInt();
		
		ids.rawliquidessenceflowing_actual = config.getBlock(config.CATEGORY_BLOCK,
				Names.rawliquidessenceflowing_name, ids.rawliquidessenceflowing_default).getInt();
		
		ids.rawliquidessencestill_actual = config.getBlock(config.CATEGORY_BLOCK,
				Names.rawliquidessencestill_name, ids.rawliquidessencestill_default).getInt();
		
		ids.rawliquidessence_actual = config.getBlock(config.CATEGORY_BLOCK,
				Names.rawliquidesence_name, ids.rawliquidessence_default).getInt();
		config.save();

	}
	/*
	 * ids.MoeMetaItem_actual = config.getItem(config.CATEGORY_ITEM,
	 * Names.MoeMetaItem, ids.MoeMetaItem_default).getInt() - 256;
	 */

}
