/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MinersTech.gui;

import MinersTech.Container.ContainerMinersFurnace;
import MinersTech.Container.ContainerOreGrinder;
import MinersTech.tileentity.TileEntityMinersFurnace;
import MinersTech.tileentity.TileEntityOreGrinder;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler{

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tile_entity = world.getBlockTileEntity(x, y, z);
		
		if(tile_entity instanceof TileEntityMinersFurnace){
			return new ContainerMinersFurnace(player.inventory, (TileEntityMinersFurnace) tile_entity);
		}
		
		if(tile_entity instanceof TileEntityOreGrinder){
			return new ContainerOreGrinder(player.inventory, (TileEntityOreGrinder) tile_entity);
		}
		
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tile_entity = world.getBlockTileEntity(x, y, z);
		
		if(tile_entity instanceof TileEntityMinersFurnace){
			return new guiMinersFurnace(player.inventory, (TileEntityMinersFurnace) tile_entity);
		}
		
		if(tile_entity instanceof TileEntityOreGrinder){
			return new guiOreGrinder(player.inventory, (TileEntityOreGrinder) tile_entity);
		}
		
		return null;
	}

}

