package Sortilegeexpansion.lib;

import Sortilegeexpansion.items.Items;
import net.minecraft.creativetab.CreativeTabs;

public class Sortilegeexpansiontab extends CreativeTabs {

	public Sortilegeexpansiontab(int id, String name) {
		super(id, name);
	}
	
	@Override
	public int getTabIconItemIndex() {
		return Items.RawEssenceChunk.itemID;
		
	}
	
	

}
