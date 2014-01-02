package Sortilegeexpansion.liquid;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class Fluidessence extends Fluid {
	
	public Fluidessence(int id){
	
	super( "example" );
	
	setDensity( 8 ); // used by the block to work out how much it slows entities
	setViscosity( 4000 ); // used by the block to work out how fast it flows
	
	FluidRegistry.registerFluid( this );
	

}
}