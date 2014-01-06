package Sortilegeexpansion.items;

import Sortilegeexpansion.blocks.Blocks;
import Sortilegeexpansion.items.decayedingots.DecayedCoalChunk;
import Sortilegeexpansion.items.decayedingots.DecayedGoldIngot;
import Sortilegeexpansion.items.decayedingots.DecayedIronIngot;
import Sortilegeexpansion.lib.config.Names;
import Sortilegeexpansion.lib.config.ids;
import net.minecraft.block.Block;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Items {
		//Items
	public static Item RawEssenceChunk;
	public static Item decayedironingot;
	public static Item decayedgoldingot;
	public static Item decayedcoalchunk;
	public static Item decayedlapischunk;
	public static Item decayeddiamondshard;
	public static Item decayedcopperingot;
	public static Item decayedtiningot;
	public static Item decayedsilveringot;
	public static Item decayedleadingot;
	public static Item lambentessence;
	public static Item recordmusic;
	

	
	


	/**
	 * This adds the Item to the mod. Hooks into moreofeverything
	 */
	public static void init() {
			//Items
		//verbal = new Verbal(ids.verbal_actual);
		RawEssenceChunk = new rawEssenceChunk(ids.rawessencechunk_actual);
		decayedironingot = new DecayedIronIngot(ids.decayedironingot_actual);
		decayedgoldingot = new DecayedGoldIngot(ids.decayedgoldingot_actual);
		decayedcoalchunk = new DecayedCoalChunk(ids.decayedcoalchunk_actual);
		decayedlapischunk = new DecayedLapisChunk(ids.decayedlapischunk_actual);
		decayeddiamondshard = new DecayedDiamondShard(ids.decayeddiamondshard_actual);
		decayedcopperingot = new DecayedCopperIngot(ids.decayedcopperingot_actual);
		decayedtiningot = new DecayedTinIngot(ids.decayedtiningot_actual);
		decayedsilveringot = new DecayedSilverIngot(ids.decayedsilveringot_actual);
		decayedleadingot = new DecayedLeadIngot(ids.decayedleadingot_actual);
		lambentessence = new LambentEssence(ids.lambentessence_actual);
		recordmusic = new recordclass(ids.recordmusic_actual, "Wakemeup").setUnlocalizedName("record").setTextureName("record_stal");



		
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
		LanguageRegistry.addName(decayedironingot, Names.decayedironingot_name);
		LanguageRegistry.addName(decayedgoldingot, Names.decayedgoldingot_name);
		LanguageRegistry.addName(decayedcoalchunk, Names.decayedcoalchunk_name);
		LanguageRegistry.addName(decayedlapischunk, Names.decayedlapischunk_name);
		LanguageRegistry.addName(decayeddiamondshard, Names.decayeddiamondchunk_name);
		LanguageRegistry.addName(decayedcopperingot, Names.decayedcopperingot_name);
		LanguageRegistry.addName(decayedtiningot, Names.decayedtiningot_name);
		LanguageRegistry.addName(decayedsilveringot, Names.decayedsilveringot_name);
		LanguageRegistry.addName(decayedleadingot, Names.decayedleadingot_name);
		LanguageRegistry.addName(lambentessence, Names.lambentessence_name);


		//DO NOT TOUCH THE COMMENT BELOW
		/**
		for (int i = 0; i < Names.MoeMetaItem_name.length; i++) {
			LanguageRegistry.addName(new ItemStack(meta, 1, i),
					Names.MoeMetaItem_name[i]);
		}
		*/
	}
}