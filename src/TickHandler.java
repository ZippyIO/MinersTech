package MinersTech;

import MinersTech.Capes.CapeHandler;
import MinersTech.Capes.Reference;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.ObfuscationReflectionHelper;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.relauncher.ReflectionHelper;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.EnumSet;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.IImageBuffer;
import net.minecraft.client.renderer.ThreadDownloadImageData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StringUtils;

public class TickHandler
  implements ITickHandler
{
  private final String label = "DNS Capes".toLowerCase().replace(" ", "_") + "_TICKHANDLER";
  private Minecraft mc;

  public void tickStart(EnumSet<TickType> type, Object[] tickData)
  {
  }

  public void tickEnd(EnumSet<TickType> type, Object[] tickData)
  {
    this.mc = Minecraft.getMinecraft();

    if (Reference.allowCape)
      try {
        cape();
      } catch (IllegalAccessException e) {
        e.printStackTrace();
      } catch (IllegalArgumentException e) {
        e.printStackTrace();
      } catch (InvocationTargetException e) {
        e.printStackTrace();
      }
  }

  private void cape() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException
  {
    if (this.mc.theWorld != null) {
      List<EntityPlayer> players = this.mc.theWorld.playerEntities;

      for (EntityPlayer player : players) {
        AbstractClientPlayer clientPlayer = (AbstractClientPlayer)player;

        ResourceLocation resourceCape = new ResourceLocation("capes/" + StringUtils.stripControlCodes(clientPlayer.username));
        Method m = ReflectionHelper.findMethod(AbstractClientPlayer.class, clientPlayer, new String[] { "func_110301_a" }, new Class[] { ResourceLocation.class, String.class, ResourceLocation.class, IImageBuffer.class });
        ThreadDownloadImageData imageData = (ThreadDownloadImageData)m.invoke(clientPlayer, new Object[] { resourceCape, CapeHandler.getUrlFor(clientPlayer), null, null });
        ObfuscationReflectionHelper.setPrivateValue(AbstractClientPlayer.class, clientPlayer, imageData, new String[] { "field_110315_c" });
        ObfuscationReflectionHelper.setPrivateValue(AbstractClientPlayer.class, clientPlayer, resourceCape, new String[] { "field_110313_e" });
      }
    }
  }

  public EnumSet<TickType> ticks()
  {
    return EnumSet.of(TickType.CLIENT);
  }

  public String getLabel()
  {
    return this.label;
  }
}
