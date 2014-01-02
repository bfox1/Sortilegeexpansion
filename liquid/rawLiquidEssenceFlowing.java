package Sortilegeexpansion.liquid;

import Sortilegeexpansion.Sortilegeexpansion;
import Sortilegeexpansion.lib.ModInfo;
import Sortilegeexpansion.lib.config.Names;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockFlowing;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;

public class rawLiquidEssenceFlowing extends BlockFlowing {

	public rawLiquidEssenceFlowing(int id) {
		super(id, Material.water);
		this.blockHardness = 100.0F;
		this.setLightOpacity(3);
		this.setUnlocalizedName(Names.rawliquidessenceflowing_unlocalizedName);
		this.setCreativeTab(Sortilegeexpansion.sortilegeexpansion);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister)
	{
		this.theIcon = new Icon[] 
				{
				iconRegister.registerIcon(ModInfo.ID.toLowerCase() + ":" + "raw_liquid_essence_still"),
				iconRegister.registerIcon(ModInfo.ID.toLowerCase() + ":" + "raw_liquid_essence_flowing")
				};
	}

}
