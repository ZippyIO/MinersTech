package MinersTech.Blocks;

import MinersTech.MinersTech;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class CommieniteBlock extends Block{

	public CommieniteBlock(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setHardness(10F);
		this.setResistance(10F);
	}
    
    @SideOnly(Side.CLIENT)
    	public void registerIcons(IconRegister iconRegister){
        this.blockIcon = iconRegister.registerIcon(MinersTech.modid + ":" + "CommieniteBlock");
    }
	
}
