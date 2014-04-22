/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MinersTech.Items.Armor;

import MinersTech.MinersTech;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

/**
 *
 * @author ZippyBling
 */
public class ZondoChestplate extends ItemArmor{

    public ZondoChestplate(int id, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4) {
        super(id, par2EnumArmorMaterial, par3, par4);
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		this.itemIcon = par1IconRegister.registerIcon(MinersTech.modid + ":"
				+ "ZondoChestplate");
	}
	
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer){
		return "minerstech:textures/models/armor/Zondo_1.png";
	}
	
}
