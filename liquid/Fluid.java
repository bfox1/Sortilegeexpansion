package Sortilegeexpansion.liquid;

import Sortilegeexpansion.blocks.Blocks;
import Sortilegeexpansion.blocks.blockfluid;
import Sortilegeexpansion.lib.config.Names;
import Sortilegeexpansion.lib.config.ids;
import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraft.block.Block;

public class Fluid {
	
	public static Fluid fluidrawessence;
	

	
	public static Material materialfluidrawessence;
	

	
	
	
	public static void inits() {
		
		fluidrawessence = new blockfluid(ids.rawliquidessence_actual).setUnlocalizedName("Name").setBlockID(Blocks.rawliquidessence.blockID);
		
	}

}
