package MinersTech.Blocks.Leaves;

import MinersTech.MinersTech;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class ZianiteLeave extends Block{

	public ZianiteLeave(int par1, Material par2Material) {
		super(par1, par2Material);
		
	}
    
    @SideOnly(Side.CLIENT)
    	public void registerIcons(IconRegister iconRegister){
        this.blockIcon = iconRegister.registerIcon(MinersTech.modid + ":" + "ZianiteLeave");
    }
}
