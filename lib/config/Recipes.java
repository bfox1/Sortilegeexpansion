package Sortilegeexpansion.lib.config;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes {

	public static void init() {
		/**
		 * This all adds the recipe for Items and blocks.
		 */
		// Block recipes
		//GameRegistry.addRecipe(new ItemStack(Blocks.verbalblock, 1),
				//new Object[] { "DDD", "DDD", "DDD", 'D', Items.verbal });

		//CraftingManager.getInstance().addRecipe(
				//new ItemStack(Blocks.verbalbrick, 4), "DD", "DD", 'D',
				//Blocks.verbalblock

		//);
	}
	public static void addSmeltingRecipes(){
		//GameRegistry.addSmelting(Items.Infusedverbal.itemID, new ItemStack(Items.Infusedingot), 5F);
		
	}
}
