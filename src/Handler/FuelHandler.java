package MinersTech.Handler;

import MinersTech.MinersTech;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;

public class FuelHandler implements IFuelHandler {

	public int getBurnTime(ItemStack fuel) {
		if(fuel.itemID == MinersTech.ZianiteCoal.itemID){
			return 20000;
		}
		return 0;

	}
}