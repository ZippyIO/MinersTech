package MinersTech.Items;

import java.util.List;

import MinersTech.MinersTech;
import MinersTech.Names;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class DustItems extends Item {
public DustItems(int id) {
super(id);
setCreativeTab(CreativeTabs.tabMisc);
setHasSubtypes(true);
}

@Override
public String getUnlocalizedName(ItemStack itemstack) {
return Names.DustItems_unlocalizedName[itemstack.getItemDamage()];
}

@SideOnly(Side.CLIENT)
public static Icon[] icons;

private static final String[] ICON = {
"dust_gold",
"dust_iron",
"dust_zondo"
};

@Override
@SideOnly(Side.CLIENT)
public void registerIcons(IconRegister icon) {
icons = new Icon[ICON.length];

for(int i = 0; i < icons.length; i++) {
icons[i] = icon.registerIcon(MinersTech.modid + ":" + ICON[i]);
}
}

@Override
@SideOnly(Side.CLIENT)
public Icon getIconFromDamage(int damage) {
return icons[damage];
}

@Override
public void getSubItems(int id, CreativeTabs tab, List list) {
for(int i = 0; i < icons.length; i++) {
ItemStack itemstack = new ItemStack(id, 1, i);
list.add(itemstack);
}
}
}
