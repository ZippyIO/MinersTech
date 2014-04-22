package MinersTech.Blocks;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import MinersTech.*;

public class ZianiteLog extends Block{

	public ZianiteLog(int par1, Material par2Material) {
		super(par1, par2Material);
		// TODO Auto-generated constructor stub
	}
		
		@SideOnly(Side.CLIENT)
		private Icon topTexture;

		
		@SideOnly(Side.CLIENT)
		public void registerIcons(IconRegister reg){
			this.blockIcon = reg.registerIcon(MinersTech.modid+ ":" + "ZianiteLog");
			this.topTexture = reg.registerIcon(MinersTech.modid + ":" + "ZianiteLog" + "_top");
		}
		
		@SideOnly(Side.CLIENT)
		public Icon getIcon(int side, int meta){
			if(side == 0 || side == 1){
				return this.topTexture;
			}
			
			return this.blockIcon;
		}
	}


