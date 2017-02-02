import org.jsoup.Jsoup;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Anderson on 02.02.2017.
 */
public class HtmlParser {
    public static void main(String[] args) throws Exception {
        String url = "https://ru.dotabuff.com/heroes/puck";
        String html = Jsoup.connect(url).get().html();
        System.out.println(html);
    }
}
