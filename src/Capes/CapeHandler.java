package MinersTech.Capes;

import cpw.mods.fml.common.FMLLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;

public class CapeHandler
{
  private static Map<String, String> capes = new HashMap();
  private static CapeHandler instance;

  public static void init()
    throws IOException
  {
    if (instance == null) {
      instance = new CapeHandler();
    }
    BufferedReader in = null;
    try
    {
      URL capeURL = new URL("http://www.dnstechpack.com/mcmanager/dnstechpack/DNSCapeList");
      in = new BufferedReader(new InputStreamReader(capeURL.openStream()));
      String inputLine;
      while ((inputLine = in.readLine()) != null) {
        FMLLog.info(inputLine, new Object[] { CapeHandler.class });
        String[] inputLineSplit = inputLine.split(";");

        if (!capes.containsKey(inputLineSplit[0])) {
          FMLLog.info("Adding DNS Cape %s;%s", new Object[] { inputLineSplit[0], inputLineSplit[1] });
          String destFile = inputLineSplit[1].substring(inputLineSplit[1].lastIndexOf('/') + 1);

          saveCape(inputLineSplit[1], destFile);

          capes.put(inputLineSplit[0].toLowerCase(), inputLineSplit[1]);
        }
      }
    }
    catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (in != null)
        in.close();
    }
  }

  public static CapeHandler instance() {
    if (instance != null)
      return instance;
    return null;
  }

  private static void saveCape(String capeURL, String destFile) throws IOException {
    System.out.println(capeURL + ", " + destFile);
    File capesDir = new File(Minecraft.getMinecraft().mcDataDir + "capes" + File.separator);
    if (!capesDir.exists()) {
      capesDir.mkdirs();
    }
    URL url = new URL(capeURL);
    InputStream is = url.openStream();
    OutputStream os = new FileOutputStream(Minecraft.getMinecraft().mcDataDir + "capes" + File.separator + destFile);

    byte[] b = new byte[2048];
    int length;
    while ((length = is.read(b)) != -1) {
      os.write(b, 0, length);
    }

    is.close();
    os.close();
  }

  public static String getUrlFor(AbstractClientPlayer clientPlayer) {
    String ret = null;
    try
    {
      String cape = handlePlayer(clientPlayer);

      if (cape != null)
        ret = cape;
      else if (Reference.staffList.contains(clientPlayer.username.toLowerCase()))
        ret = "http://www.dnstechpack.com/Downloads/capes/AdminCape.png";
      else
        ret = "http://www.dnstechpack.com/Downloads/capes/UserCape.png";
    }
    catch (Exception e) {
      e.printStackTrace();
    }

    return ret;
  }

  private static String handlePlayer(AbstractClientPlayer clientPlayer) throws Exception {
    String username = clientPlayer.username.toLowerCase();

    if (capes.containsKey(username)) {
      return (String)capes.get(username);
    }

    return null;
  }
}
