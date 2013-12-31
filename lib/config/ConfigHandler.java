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
		
		ids.newchest_acutal = config.getBlock(config.CATEGORY_BLOCK,
				Names.Newchest_name, ids.newchest_default).getInt();
		
		ids.blockDecayerActive_actual = config.getBlock(config.CATEGORY_BLOCK,
				Names.blockDecayerActive_name, ids.blockDecayerActive_default).getInt();
		
		ids.blockDecayerIdle_actual = config.getBlock(config.CATEGORY_BLOCK,
				Names.blockDecayerIdle_name, ids.blockDecayerIdle_default).getInt();
		config.save();

	}
	/*
	 * ids.MoeMetaItem_actual = config.getItem(config.CATEGORY_ITEM,
	 * Names.MoeMetaItem, ids.MoeMetaItem_default).getInt() - 256;
	 */

}
