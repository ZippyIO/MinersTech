package MinersTech.Items.Toolsi;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemPickaxe;

public class CommienitePickaxe extends ItemPickaxe{

	public CommienitePickaxe(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);

		
		
	}
	
	public void addEnchantment(Enchantment par1Enchantment, int par2){
		
		this.addEnchantment(Enchantment.efficiency, 4);
		this.addEnchantment(Enchantment.silkTouch, 4);
		this.addEnchantment(Enchantment.unbreaking, 5);
		
	}

}
