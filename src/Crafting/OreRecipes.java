/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MinersTech.Crafting;

import MinersTech.MinersTech;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

/**
 *
 * @author ZippyBling
 */
public class OreRecipes{

	private static final FurnaceRecipes oreBase = FurnaceRecipes.smelting();
	
	public static FurnaceRecipes ores(){
		return oreBase;
	}
	
	static{
		oreBase.addSmelting(Block.oreCoal.blockID, new ItemStack(Item.coal), 1F);
	}
	
}
