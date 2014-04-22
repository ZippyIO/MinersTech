package MinersTech.Items;

import MinersTech.Items.items.ingotZirconium;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;


public class Items {
	
	public static Item ingotZirconium;
	
	public static void init() {
		ingotZirconium = new ingotZirconium(ItemInfo.ingotZirconium_ID);
		GameRegistry.registerItem(ingotZirconium, ItemInfo.ingotZirconium_KEY);
	}

	public static void addNames() {
		LanguageRegistry.addName(ingotZirconium, ItemInfo.ingotZirconium_NAME);
	}
}
