	package Sortilegeexpansion.blocks;

import java.util.Random;

import Sortilegeexpansion.Sortilegeexpansion;
import Sortilegeexpansion.lib.ModInfo;
import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
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

	public class BlockDecayer extends BlockContainer{

		private final Random decayerRand = new Random();

		private final boolean isActive;

		private static boolean keepDecayerInventory;
		@SideOnly(Side.CLIENT)
		private Icon maceratorIconTop;
		
		public BlockDecayer(int id, boolean isActive) {
			super(id, Material.rock);
			
			this.isActive = isActive;
		}
		
		@SideOnly(Side.CLIENT)
		public void registerIcons(IconRegister iconRegister){
			this.blockIcon = iconRegister.registerIcon(ModInfo.ID.toLowerCase() + ":" + "decayer_side");
			this.maceratorIconTop = iconRegister.registerIcon(ModInfo.ID.toLowerCase() + ":" + (this.isActive ? "decayer_front_lit" : "decayer_front_idle"));
		}
		
		@SideOnly(Side.CLIENT)

		/**
		 * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
		 */
		public Icon getIcon(int par1, int par2)
		{
			return par1 == 1 ? this.blockIcon : (par1 == 0 ? this.blockIcon : (par1 != par2 ? this.blockIcon : this.maceratorIconTop));
		}
		
		/**
		 * Returns the ID of the items to drop on destruction.
		 */
		public int idDropped(int par1, Random par2Random, int par3)
		{
			return Blocks.blockDecayerIdle.blockID;
		}   

		/**
		 * Called whenever the block is added into the world. Args: world, x, y, z
		 */
		public void onBlockAdded(World par1World, int par2, int par3, int par4)
		{
			super.onBlockAdded(par1World, par2, par3, par4);
			this.setDefaultDirection(par1World, par2, par3, par4);
		}

		/**
		 * set a blocks direction
		 */
		private void setDefaultDirection(World par1World, int par2, int par3, int par4)
		{
			if (!par1World.isRemote)
			{
				int l = par1World.getBlockId(par2, par3, par4 - 1);
				int i1 = par1World.getBlockId(par2, par3, par4 + 1);
				int j1 = par1World.getBlockId(par2 - 1, par3, par4);
				int k1 = par1World.getBlockId(par2 + 1, par3, par4);
				byte b0 = 3;

				if (Block.opaqueCubeLookup[l] && !Block.opaqueCubeLookup[i1])
				{
					b0 = 3;
				}

				if (Block.opaqueCubeLookup[i1] && !Block.opaqueCubeLookup[l])
				{
					b0 = 2;
				}

				if (Block.opaqueCubeLookup[j1] && !Block.opaqueCubeLookup[k1])
				{
					b0 = 5;
				}

				if (Block.opaqueCubeLookup[k1] && !Block.opaqueCubeLookup[j1])
				{
					b0 = 4;
				}

				par1World.setBlockMetadataWithNotify(par2, par3, par4, b0, 2);
			}
		}

		//public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
			//if(!world.isRemote) {
				//player.openGui(Sortilegeexpansion.instance, Sortilegeexpansion.guiIdDecayer, world, x, y, z);
			//}
			
			//return true;
		//}
		@Override
	        public boolean onBlockActivated(World world, int x, int y, int z,
                    EntityPlayer player, int metadata, float what, float these, float are) {
            TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
            if (tileEntity == null || player.isSneaking()) {
                    return false;
            }
    //code to open gui explained later
    player.openGui(Sortilegeexpansion.instance, 0, world, x, y, z);
            return true;
    }

		/**
		 * Update which block ID the furnace is using depending on whether or not it is burning
		 */
		public static void updateFurnaceBlockState(boolean par0, World par1World, int par2, int par3, int par4)
		{
			int l = par1World.getBlockMetadata(par2, par3, par4);
			TileEntity tileentity = par1World.getBlockTileEntity(par2, par3, par4);
			keepDecayerInventory = true;

			if (par0)
			{
				par1World.setBlock(par2, par3, par4, Blocks.blockDecayerActive.blockID);
			}
			else
			{
				par1World.setBlock(par2, par3, par4, Blocks.blockDecayerIdle.blockID);
			}

			keepDecayerInventory = false;
			par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);

			if (tileentity != null)
			{
				tileentity.validate();
				par1World.setBlockTileEntity(par2, par3, par4, tileentity);
			}
		}

		/**
		 * Returns a new instance of a block's tile entity class. Called on placing the block.
		 */
		public TileEntity createNewTileEntity(World par1World)
		{
			return new TileEntityDecayer();
		}

		/**
		 * Called when the block is placed in the world.
		 */
		public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack)
		{
			int l = MathHelper.floor_double((double)(par5EntityLivingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

			if (l == 0)
			{
				par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 2);
			}

			if (l == 1)
			{
				par1World.setBlockMetadataWithNotify(par2, par3, par4, 5, 2);
			}

			if (l == 2)
			{
				par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 2);
			}

			if (l == 3)
			{
				par1World.setBlockMetadataWithNotify(par2, par3, par4, 4, 2);
			}

			if (par6ItemStack.hasDisplayName())
			{
				((TileEntityDecayer)par1World.getBlockTileEntity(par2, par3, par4)).setGuiDisplayName(par6ItemStack.getDisplayName());
			}
		}

		/**
		 * ejects contained items into the world, and notifies neighbours of an update, as appropriate
		 */
		public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
		{
			if (!keepDecayerInventory)
			{
				TileEntityDecayer TileEntityMacerator = (TileEntityDecayer)par1World.getBlockTileEntity(par2, par3, par4);

				if (TileEntityMacerator != null)
				{
					for (int j1 = 0; j1 < TileEntityMacerator.getSizeInventory(); ++j1)
					{
						ItemStack itemstack = TileEntityMacerator.getStackInSlot(j1);

						if (itemstack != null)
						{
							float f = this.decayerRand.nextFloat() * 0.8F + 0.1F;
							float f1 = this.decayerRand.nextFloat() * 0.8F + 0.1F;
							float f2 = this.decayerRand.nextFloat() * 0.8F + 0.1F;

							while (itemstack.stackSize > 0)
							{
								int k1 = this.decayerRand.nextInt(21) + 10;

								if (k1 > itemstack.stackSize)
								{
									k1 = itemstack.stackSize;
								}

								itemstack.stackSize -= k1;
								EntityItem entityitem = new EntityItem(par1World, (double)((float)par2 + f), (double)((float)par3 + f1), (double)((float)par4 + f2), new ItemStack(itemstack.itemID, k1, itemstack.getItemDamage()));

								if (itemstack.hasTagCompound())
								{
									entityitem.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
								}

								float f3 = 0.05F;
								entityitem.motionX = (double)((float)this.decayerRand.nextGaussian() * f3);
								entityitem.motionY = (double)((float)this.decayerRand.nextGaussian() * f3 + 0.2F);
								entityitem.motionZ = (double)((float)this.decayerRand.nextGaussian() * f3);
								par1World.spawnEntityInWorld(entityitem);
							}
						}
					}

					par1World.func_96440_m(par2, par3, par4, par5);
				}
			}

			super.breakBlock(par1World, par2, par3, par4, par5, par6);
		}

		/**
		 * If this returns true, then comparators facing away from this block will use the value from
		 * getComparatorInputOverride instead of the actual redstone signal strength.
		 */
		public boolean hasComparatorInputOverride()
		{
			return true;
		}

		/**
		 * If hasComparatorInputOverride returns true, the return value from this is used instead of the redstone signal
		 * strength when this block inputs to a comparator.
		 */
		public int getComparatorInputOverride(World par1World, int par2, int par3, int par4, int par5)
		{
			return Container.calcRedstoneFromInventory((IInventory)par1World.getBlockTileEntity(par2, par3, par4));
		}

		@SideOnly(Side.CLIENT)

		/**
		 * only called by clickMiddleMouseButton , and passed to inventory.setCurrentItem (along with isCreative)
		 */
		public int idPicked(World par1World, int par2, int par3, int par4)
		{
			return Blocks.blockDecayerIdle.blockID;
		}
		
	}