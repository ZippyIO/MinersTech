/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MinersTech.Items.Tools;

import MinersTech.MinersTech;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemAxe;

/**
 *
 * @author ZippyBling
 */
public class ZondoAxe extends ItemAxe{

    public ZondoAxe(int id, EnumToolMaterial par2EnumToolMaterial) {
        super(id, par2EnumToolMaterial);
    }
     
     
        @SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister){
            this.itemIcon = iconRegister.registerIcon(MinersTech.modid + ":" + "ZondoAxe");
    }
    
}
