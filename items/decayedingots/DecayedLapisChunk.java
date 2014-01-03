package Sortilegeexpansion.items.decayedingots;

import Sortilegeexpansion.Sortilegeexpansion;
import Sortilegeexpansion.lib.ModInfo;
import Sortilegeexpansion.lib.config.Names;
import net.minecraft.item.Item;

public class DecayedLapisChunk extends Item {
	
	public DecayedLapisChunk(int id){
		super(id);
		this.setCreativeTab(Sortilegeexpansion.sortilegeexpansion);
		this.setMaxStackSize(64);
		this.setUnlocalizedName(Names.decayedcoalchunk_UnlocalizedName);
		this.setTextureName(ModInfo.ID.toLowerCase() + ":" + Names.decayedcoalchunk_UnlocalizedName);
	}

}
