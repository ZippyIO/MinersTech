package MinersTech.Capes;

import java.io.IOException;
import java.util.Properties;

import MinersTech.MinersTech;

public class Settings
{
  private final Properties properties;

  public Settings()
  {
    this.properties = new Properties();
    try
    {
      this.properties.load(MinersTech.class.getClassLoader().getResourceAsStream("ModPack"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public Object get(String key) {
    return this.properties.get(key);
  }
}