package Sortilegeexpansion.blocks;

import org.lwjgl.opengl.GL11;

import Sortilegeexpansion.lib.ModInfo;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;


public class GuiDecayer extends GuiContainer{
	public static final ResourceLocation texture = new ResourceLocation(ModInfo.ID.toLowerCase(), "/textures/gui/decayer.png");
	
	public TileEntityDecayer decayer;
	
	public GuiDecayer(InventoryPlayer invPlayer, TileEntityDecayer entity) {
		super(new ContainerDecayer(invPlayer, entity));
		
		this.decayer = entity;

		this.xSize = 176;
		this.ySize = 165;
	}
	
	public void drawGuiContainerForegroundLayer(int par1, int par2){
		String s = this.decayer.isInvNameLocalized() ? this.decayer.getInvName() : I18n.getString(this.decayer.getInvName());
		this.fontRenderer.drawString(s, this.xSize / 2 - this.fontRenderer.getStringWidth(s) / 2, 6, 4210752);
		this.fontRenderer.drawString(I18n.getString("container.inventory"), 8, this.ySize - 96 + 5, 4210752);
	}
	
	public void drawGuiContainerBackgroundLayer(float f, int j, int i) {
		GL11.glColor4f(1F, 1F, 1F, 1F);
		
		Minecraft.getMinecraft().getTextureManager().
		bindTexture(texture);
		
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		
		int i1;

		if(this.decayer.hasPower()){
			i1 = this.decayer.getPowerRemainingScaled(45);
			this.drawTexturedModalRect(guiLeft + 8, guiTop + 53 - i1, 176, 63 - i1, 16, i1);
		}
		
		i1 = this.decayer.getCookProgressScaled(20);
		this.drawTexturedModalRect(guiLeft + 79, guiTop + 34, 176, 0, i1 + 1, 18);
	}
}