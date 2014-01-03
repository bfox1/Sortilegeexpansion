package Sortilegeexpansion.items;

import Sortilegeexpansion.Sortilegeexpansion;
import Sortilegeexpansion.lib.ModInfo;
import Sortilegeexpansion.lib.config.Names;
import net.minecraft.item.Item;

public class DecayedSilverIngot extends Item {
	
	public DecayedSilverIngot(int id){
		super(id);
		this.setCreativeTab(Sortilegeexpansion.sortilegeexpansion);
		this.setMaxStackSize(64);
		this.setUnlocalizedName(Names.decayedsilveringot_UnlocalizedName);
		this.setTextureName(ModInfo.ID.toLowerCase() + ":" + Names.decayedsilveringot_UnlocalizedName);
	}

}
