package Sortilegeexpansion.items;

import Sortilegeexpansion.blocks.Blocks;
import Sortilegeexpansion.lib.config.Names;
import Sortilegeexpansion.lib.config.ids;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Items {
		//Items
	public static Item RawEssenceChunk;
	

	
	


	/**
	 * This adds the Item to the mod. Hooks into moreofeverything
	 */
	public static void init() {
			//Items
		//verbal = new Verbal(ids.verbal_actual);
		RawEssenceChunk = new rawEssenceChunk(ids.rawessencechunk_actual);



		
			//LEAVE COMMENT BELOW ALONE	
		/*
		 * meta = new MoeMetaItem(ids.MoeMetaItem_actual);
		 */
		
			//Tools
		//scepter = new Scepter(ids.Scepter_actual);
		

		
	}

	// This adds the name of the item which hooks into Names.
	public static void addNames() {
			//Items
		//LanguageRegistry.addName(verbal, Names.Verbal_name);
		LanguageRegistry.addName(RawEssenceChunk, Names.rawessencechunk_name);


		//DO NOT TOUCH THE COMMENT BELOW
		/**
		for (int i = 0; i < Names.MoeMetaItem_name.length; i++) {
			LanguageRegistry.addName(new ItemStack(meta, 1, i),
					Names.MoeMetaItem_name[i]);
		}
		*/
	}
}