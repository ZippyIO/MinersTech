package MinersTech.Capes;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class URLHelper
{
  public static String retrieveString(String url)
  {
    String urlContent = "1.0.1_local";
    try
    {
      BufferedReader urlReader = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
      urlContent = urlReader.readLine();
    } catch (Exception e) {
      e.printStackTrace();
    }

    return urlContent;
  }

  public static List<String> retrieveStringList(String url) {
List<String> ret = new ArrayList<String>();

      try {
          BufferedReader urlReader = new BufferedReader(new InputStreamReader(new URL(url).openStream()));

          String line;
          while((line = urlReader.readLine()) != null) {

              ret.add(line.toLowerCase(Locale.ENGLISH));
          }

          return ret;
      } catch(Exception e) {

          e.printStackTrace();
          return Arrays.asList("ZippyBling", "ZOMGITSACREEPER");
      }
  }
}
