/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MinersTech.Misc;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import java.io.File;
import java.util.logging.Level;
import net.minecraftforge.common.Configuration;

/**
 *
 * @author ZippyBling
 */
 public class Config
 {
  public static Configuration configuration;
  
  public static int oreZondoI;
  public static int MaceratorIdleI;
  public static int MaceratorActiveI;
  
 public void preInit(FMLPreInitializationEvent event){
		Configuration Config = new Configuration(new File("config/MinersTech/MinersTech.cfg"));
		Config.load();
                
                
                oreZondoI = Config.get("Blocks", "Zondo Ore", 3790).getInt();
		MaceratorIdleI = Config.get("Blocks", "Macerator Idle", 3795).getInt();
                MaceratorActiveI = Config.get("Blocks", "Macerator Active", 3799).getInt();

		Config.save();
   }
}
