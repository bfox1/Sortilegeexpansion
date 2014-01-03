package Sortilegeexpansion.blocks;

import Sortilegeexpansion.Sortilegeexpansion;
import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class BlockRawLiquidEssence extends BlockFluidClassic{

	public BlockRawLiquidEssence(int id) {
		super(id, Blocks.fluidrawliquidessence, Material.water);
		
		this.setCreativeTab(Sortilegeexpansion.sortilegeexpansion);
	}

}
