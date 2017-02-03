import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.util.regex.Pattern;

/**
 * Created by Anderson on 02.02.2017.
 */
public class HtmlParser {
    public static void main(String[] args) throws Exception {

        String current = new java.io.File(".").getCanonicalPath();
        System.out.println(current);
        current += "/src/main/resources/tmp/Puck/Puck.html";
//        current += "/matchups";
        System.out.println(current);

        // Load a Doc from a File
        File input = new File(current);
        Document doc = Jsoup.parse(input, "UTF-8", "http://example.com/");
        //  String url = "https://ru.dotabuff.com/heroes/puck";
        // String html = Jsoup.connect(url).get().html();
        //Load a Doc from a Url
        // Document doc = Jsoup.connect(url).get();
        Elements content = doc.getElementsByTag("section");
        Elements targetSection = null;
        for (Element e : content) {
            targetSection = e.select("section:contains(Слаб против)");
            if (targetSection.size() > 0) {
                break;
            }
            System.out.println(targetSection);
        }

        Element element = targetSection.get(0);
        Elements elementsByAttribute = element.getElementsByAttribute("data-link-to");

//        System.out.println(element);
        /*
        Elements links = targetSection.select("a[class=link-type-hero]");
        System.out.println("-----------------------");
        System.out.println(links);
        for (Element e : links) {
            System.out.println(e.toString().substring(32));
        }
        */
        System.out.println(targetSection);
    }
}
