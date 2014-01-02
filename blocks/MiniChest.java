package Sortilegeexpansion.blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import Sortilegeexpansion.Sortilegeexpansion;
import Sortilegeexpansion.lib.ModInfo;
import Sortilegeexpansion.lib.config.Names;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class MiniChest extends BlockContainer {
	
		protected MiniChest(int id){
			super(id, Material.wood);
			setHardness(2.0F);
			setResistance(5.0F);
			setUnlocalizedName(Names.Newchest_unlocalizedName);
			setCreativeTab(Sortilegeexpansion.sortilegeexpansion);
			
		}

		@SideOnly(Side.CLIENT)
		private Icon iconFront;

		@SideOnly(Side.CLIENT)
		public void registerIcons(IconRegister iconRegister) {
			this.blockIcon = iconRegister.registerIcon(ModInfo.ID.toLowerCase()
					+ ":" + "mini_chest_side");
			this.iconFront = iconRegister.registerIcon(ModInfo.ID.toLowerCase()
					+ ":" + ("mini_chest_front"));
		}
		@SideOnly(Side.CLIENT)
		public Icon getIcon(int side, int metadata){
			return side == metadata ?  this.iconFront : this.blockIcon;
		}
		
        @Override
        public boolean onBlockActivated(World world, int x, int y, int z,
                        EntityPlayer player, int metadata, float what, float these, float are) {
                TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
                if (tileEntity == null || player.isSneaking()) {
                        return false;
                }
        //code to open gui explained later
        player.openGui(Sortilegeexpansion.instance1, Sortilegeexpansion.guiIdminichest, world, x, y, z);
                return true;
        }
    	private void setDefaultDirection(World world, int x, int y, int z){
    		if(!world.isRemote){
    			int l = world.getBlockId(x, y, z - 1);
    			int il = world.getBlockId(x, y, z + 1);
    			int jl = world.getBlockId(x - 1, y, z);
    			int kl = world.getBlockId(x + 1, y, z);
    			
    		byte b0 = 3;
    		
    			if(Block.opaqueCubeLookup[l] && !Block.opaqueCubeLookup[il]){
    				b0 = 3;
    			}
    			if(Block.opaqueCubeLookup[il] && !Block.opaqueCubeLookup[l]){
    				b0 = 2;
    			}
    			if(Block.opaqueCubeLookup[kl] && !Block.opaqueCubeLookup[jl]){
    				b0 = 5;
    			}
    			if(Block.opaqueCubeLookup[jl] && !Block.opaqueCubeLookup[kl]){
    				b0 = 4;
    			}
    			
    		
    		world.setBlockMetadataWithNotify(x, y, z, b0, 2);
    	}
    	}

        @Override
        public void breakBlock(World world, int x, int y, int z, int par5, int par6) {
                dropItems(world, x, y, z);
                super.breakBlock(world, x, y, z, par5, par6);
        }

        private void dropItems(World world, int x, int y, int z){
                Random rand = new Random();

                TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
                if (!(tileEntity instanceof IInventory)) {
                        return;
                }
                IInventory inventory = (IInventory) tileEntity;

                for (int i = 0; i < inventory.getSizeInventory(); i++) {
                        ItemStack item = inventory.getStackInSlot(i);

                        if (item != null && item.stackSize > 0) {
                                float rx = rand.nextFloat() * 0.8F + 0.1F;
                                float ry = rand.nextFloat() * 0.8F + 0.1F;
                                float rz = rand.nextFloat() * 0.8F + 0.1F;

                                EntityItem entityItem = new EntityItem(world,
                                                x + rx, y + ry, z + rz,
                                                new ItemStack(item.itemID, item.stackSize, item.getItemDamage()));

                                if (item.hasTagCompound()) {
                                        entityItem.getEntityItem().setTagCompound((NBTTagCompound) item.getTagCompound().copy());
                                }

                                float factor = 0.05F;
                                entityItem.motionX = rand.nextGaussian() * factor;
                                entityItem.motionY = rand.nextGaussian() * factor + 0.2F;
                                entityItem.motionZ = rand.nextGaussian() * factor;
                                world.spawnEntityInWorld(entityItem);
                                item.stackSize = 0;
                        }
                }
        }

        @Override
        public TileEntity createNewTileEntity(World world) {
                return new TileEntityMiniChest();
        }
        public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase, ItemStack itemstack){
    		int l = MathHelper.floor_double((double) (entityLivingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
    		
    		if(l == 0){
    			world.setBlockMetadataWithNotify(x, y, z, 2, 2);
    		}
    		
    		if(l == 1){
    			world.setBlockMetadataWithNotify(x, y, z, 5, 2);
    			
    		}
    		
    		if(l == 2){
    			world.setBlockMetadataWithNotify(x, y, z, 3, 2);
    			
    		}
    		
    		if(l == 3){
    			world.setBlockMetadataWithNotify(x, y, z, 4, 2);
    			
    		}

    		
    	}
        

}
