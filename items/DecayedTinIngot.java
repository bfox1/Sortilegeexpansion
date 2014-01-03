package Sortilegeexpansion.items;

import Sortilegeexpansion.Sortilegeexpansion;
import Sortilegeexpansion.lib.ModInfo;
import Sortilegeexpansion.lib.config.Names;
import net.minecraft.item.Item;

public class DecayedTinIngot extends Item {
	
	public DecayedTinIngot(int id){
		super(id);
		this.setCreativeTab(Sortilegeexpansion.sortilegeexpansion);
		this.setMaxStackSize(64);
		this.setUnlocalizedName(Names.decayedtiningot_UnlocalizedName);
		this.setTextureName(ModInfo.ID.toLowerCase() + ":" + Names.decayedtiningot_UnlocalizedName);
	}

}
