package Sortilegeexpansion.lib;

import Sortilegeexpansion.items.Items;
import net.minecraft.creativetab.CreativeTabs;

public class SortilegeexpansionToolsTab extends CreativeTabs {

	public SortilegeexpansionToolsTab(int id, String name) {
		super(id, name);
	}
	
	/**
	 * This is where the Tab Icon for whatever you would like
	 * 
	 */
	@Override
	public int getTabIconItemIndex() {
		return Items.RawEssenceChunk.itemID;
		
	}
	
	

}

