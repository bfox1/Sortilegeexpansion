package Sortilegeexpansion.items;

import Sortilegeexpansion.Sortilegeexpansion;
import Sortilegeexpansion.lib.ModInfo;
import Sortilegeexpansion.lib.config.Names;
import net.minecraft.item.Item;

public class LambentEssence extends Item {
	
	public LambentEssence(int id){
		super(id);
		this.setCreativeTab(Sortilegeexpansion.sortilegeexpansion);
		this.setMaxStackSize(64);
		this.setUnlocalizedName(Names.lambentessence_UnlocalizedName);
		this.setTextureName(ModInfo.ID.toLowerCase() + ":" + Names.lambentessence_UnlocalizedName);
	}

}
