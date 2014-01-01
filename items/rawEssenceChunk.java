package Sortilegeexpansion.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import Sortilegeexpansion.Sortilegeexpansion;
import Sortilegeexpansion.lib.ModInfo;
import Sortilegeexpansion.lib.config.Names;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class rawEssenceChunk extends Item {

	public rawEssenceChunk(int id) {
		super(id);
		setUnlocalizedName(Names.rawessencechunk_unlocalizedName);
		setCreativeTab(Sortilegeexpansion.sortilegeexpansion);
		setMaxStackSize(64);
		
		
		
	}
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon(ModInfo.ID.toLowerCase()
				+ ":" + "raw_essence_chunk");
}
}