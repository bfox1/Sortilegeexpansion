package Sortilegeexpansion.gui;

import Sortilegeexpansion.blocks.TileEntityDecayer;
import Sortilegeexpansion.blocks.TileEntityMiniChest;
import Sortilegeexpansion.container.ContainerDecayer;
import Sortilegeexpansion.container.Containernewchest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {
    //returns an instance of the Container you made earlier
	
    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world,
                    int x, int y, int z) {
            TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
            
            switch(id)
            {
            case 7:
            	if(tileEntity != null && tileEntity instanceof TileEntityMiniChest){
                    return new Containernewchest(player.inventory, (TileEntityMiniChest) tileEntity);
            }else{
            	return null;
            }
            case 8:
                if(tileEntity instanceof TileEntityDecayer){
                    return new ContainerDecayer(player.inventory, (TileEntityDecayer) tileEntity);
                }else{
                	return null;
                }
            	
            default:
            	return null;
            }
    }

    //returns an instance of the Gui you made earlier
    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world,
                    int x, int y, int z) {
            TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
            
            switch(id)
            {
            case 7:
            	if(tileEntity != null && tileEntity instanceof TileEntityMiniChest)
            	{
            		return new GuiMiniChest(player.inventory, (TileEntityMiniChest) tileEntity);
            	}else{
            		return null;
            }
            case 8:
            	if(tileEntity != null && tileEntity instanceof TileEntityDecayer)
            	{
            		return new GuiDecayer(player.inventory, (TileEntityDecayer) tileEntity);
            	}else{
            		return null;
            	}
            	default:
            		return null;
            }


    }

}