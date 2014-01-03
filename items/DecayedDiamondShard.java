package Sortilegeexpansion.items;

import Sortilegeexpansion.Sortilegeexpansion;
import Sortilegeexpansion.lib.ModInfo;
import Sortilegeexpansion.lib.config.Names;
import net.minecraft.item.Item;

public class DecayedDiamondShard extends Item {
	
	public DecayedDiamondShard(int id){
		super(id);
		this.setCreativeTab(Sortilegeexpansion.sortilegeexpansion);
		this.setMaxStackSize(64);
		this.setUnlocalizedName(Names.decayeddiamondchunk_UnlocalizedName);
		this.setTextureName(ModInfo.ID.toLowerCase() + ":" + Names.decayeddiamondchunk_UnlocalizedName);
	}

}
