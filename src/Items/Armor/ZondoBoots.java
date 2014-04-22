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
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

/**
 *
 * @author ZippyBling
 */
public class ZondoBoots extends ItemArmor{

    public ZondoBoots(int id, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4) {
        super(id, par2EnumArmorMaterial, par3, par4);
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		this.itemIcon = par1IconRegister.registerIcon(MinersTech.modid + ":"
				+ "ZondoBoots");
	}
	
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer){
		return "minerstech:textures/models/armor/Zondo_1.png";
	}
	public void onArmorTickUpdate(World world, EntityPlayer player, ItemStack stack)
	{
	if (player.getCurrentItemOrArmor(4) != null && player.getCurrentArmor(3) != null && player.getCurrentItemOrArmor(2) != null && player.getCurrentItemOrArmor(1) != null) {
	ItemStack helmet = player.getCurrentItemOrArmor(4);
	ItemStack plate = player.getCurrentItemOrArmor(3);
	ItemStack legs = player.getCurrentItemOrArmor(2);
	ItemStack boots = player.getCurrentItemOrArmor(1);

	if (helmet.getItem() == MinersTech.ZondoHelmet && plate.getItem() == MinersTech.ZondoChestplate && legs.getItem() == MinersTech.ZondoLeggings && boots.getItem() == MinersTech.ZondoBoots) {
	player.addPotionEffect((new PotionEffect(Potion.digSpeed.getId(), 200, 1)));
	player.addPotionEffect((new PotionEffect(Potion.damageBoost.getId(), 200, 1)));
	player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 200, 1));
	}
}
	}	
}
