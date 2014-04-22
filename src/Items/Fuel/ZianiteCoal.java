package MinersTech.Items.Fuel;

import MinersTech.MinersTech;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ZianiteCoal extends Item{

	public ZianiteCoal(int par1) {
		super(par1);

	}
    
    
    @SideOnly(Side.CLIENT)
    	public void registerIcons(IconRegister iconRegister){
        this.itemIcon = iconRegister.registerIcon(MinersTech.modid + ":" + "ZianiteCoal");
}

}
