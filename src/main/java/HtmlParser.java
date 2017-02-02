import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Anderson on 02.02.2017.
 */
public class HtmlParser {
    public static void main(String[] args) throws Exception {
        String url = "https://ru.dotabuff.com/heroes/slark";
       // String url = "https://ru.wikipedia.org/wiki";
        String codePage = "UTF8";
        String html = "";
        StringBuilder sb = new StringBuilder();
        URL pageURL = new URL(url);
        URLConnection uc = pageURL.openConnection();
        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        uc.getInputStream(), codePage));
        try {
            String inputLine;
          while ((inputLine = br.readLine()) != null) {
                sb.append(inputLine);
            }
        } finally {
            br.close();
        }
       html = sb.toString();
        System.out.println(html);
    }

}
