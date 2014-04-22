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
import net.minecraft.item.ItemSword;

/**
 *
 * @author ZippyBling
 */
public class ZondoSword extends ItemSword{

    public ZondoSword(int id, EnumToolMaterial par2EnumToolMaterial) {
        super(id, par2EnumToolMaterial);
    }
     
     
        @SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister){
            this.itemIcon = iconRegister.registerIcon(MinersTech.modid + ":" + "ZondoSword");
    }
    
}
