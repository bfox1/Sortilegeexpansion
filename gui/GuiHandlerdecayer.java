package Sortilegeexpansion.gui;

import Sortilegeexpansion.blocks.TileEntityDecayer;
import Sortilegeexpansion.container.ContainerDecayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandlerdecayer implements IGuiHandler {
    //returns an instance of the Container you made earlier
    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world,
                    int x, int y, int z) {
            TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
            if(tileEntity instanceof TileEntityDecayer){
                    return new ContainerDecayer(player.inventory, (TileEntityDecayer) tileEntity);
            }
            return null;
    }

    //returns an instance of the Gui you made earlier
    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world,
                    int x, int y, int z) {
            TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
            if(tileEntity instanceof TileEntityDecayer){
                    return new GuiDecayer(player.inventory, (TileEntityDecayer) tileEntity);
            }
            return null;

    }
}