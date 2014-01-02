package Sortilegeexpansion.gui;

import org.lwjgl.opengl.GL11;

import Sortilegeexpansion.blocks.TileEntityMiniChest;
import Sortilegeexpansion.container.Containernewchest;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

public class GuiMiniChest extends GuiContainer {
	
	public static final ResourceLocation texture = new ResourceLocation(Sortilegeexpansion.lib.ModInfo.ID.toLowerCase(), "/textures/gui/trap.png");
    public GuiMiniChest (InventoryPlayer inventoryPlayer,
            TileEntityMiniChest tileEntity) {
    //the container is instanciated and passed to the superclass for handling
    super(new Containernewchest(inventoryPlayer, tileEntity));
    
    this.xSize = 176;
    this.ySize = 166;
}

@Override
protected void drawGuiContainerForegroundLayer(int param1, int param2) {
    //draw text and stuff here
    //the parameters for drawString are: string, x, y, color
    fontRenderer.drawString("Mini Chest", 8, 6, 4210752);
    //draws "Inventory" or your regional equivalent
    fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);
}

@Override
protected void drawGuiContainerBackgroundLayer(float par1, int par2,
            int par3) {
    //draw your Gui here, only thing you need to change is the path
    //int texture = mc.renderEngine.getTexture("/gui/trap.png");
	Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    //this.mc.renderEngine.bindTexture(texture);
    int x = (width - xSize) / 2;
    int y = (height - ySize) / 2;
    
    this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
}
}
