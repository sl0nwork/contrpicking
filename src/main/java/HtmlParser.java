import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;

/**
 * Created by Anderson on 02.02.2017.
 */
public class HtmlParser {
    public static void main(String[] args) throws Exception {

        // Load a Doc from a File
        File input = new File("D:/Youtube/contrpicking/src/main/resources/tmp/Puck/Puck.html");
        Document doc = Jsoup.parse(input, "UTF-8", "http://example.com/");
      //  String url = "https://ru.dotabuff.com/heroes/puck";
       // String html = Jsoup.connect(url).get().html();
        //Load a Doc from a Url
       // Document doc = Jsoup.connect(url).get();
        Elements content = doc.getElementsByTag("section");
        Elements targetSection = null;
        for (Element e:content) {
          targetSection = e.select("section:contains(Слаб против)");
            if(targetSection.size() != 0)
                break;
        }
        Elements links = targetSection.select("a[class=link-type-hero]");
        System.out.println("-----------------------");
        System.out.println(links);
    }
}
