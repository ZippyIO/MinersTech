/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MinersTech.Items.Ingots;

import MinersTech.MinersTech;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

/**
 *
 * @author ZippyBling
 */
public class ingotZondo extends Item{

    public ingotZondo(int id) {
        super(id);
    }
    
     
        @SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister){
            this.itemIcon = iconRegister.registerIcon(MinersTech.modid + ":" + "ZondoIngot");
    }
    
}
