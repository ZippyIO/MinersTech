/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MinersTech.Blocks.Ores;

import MinersTech.MinersTech;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

/**
 *
 * @author ZippyBling
 */
public class oreZondo extends Block{

    public oreZondo(int id, Material par2Material) {
        super(id, par2Material);
    }
    
        @SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister){
            this.blockIcon = iconRegister.registerIcon(MinersTech.modid + ":" + "oreZondo");
    }
        
        
}
