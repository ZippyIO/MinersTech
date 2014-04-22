package MinersTech.Proxy;

import MinersTech.TickHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class ClientProxy extends ServerProxy
{
	
    public int addArmor(String armor) {
		return RenderingRegistry.addNewArmourRendererPrefix(armor);
    }
    
    public void registerTickHandler()
    {
      TickRegistry.registerTickHandler(new TickHandler(), Side.CLIENT);
    }
} 


