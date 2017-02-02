import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Created by Anderson on 02.02.2017.
 */
public class HtmlParser {
    public static void main(String[] args) throws Exception {
        String url = "https://ru.dotabuff.com/heroes/puck";
        String html = Jsoup.connect(url).get().html();
        Document doc = Jsoup.connect(url).get();
        Elements content = doc.getElementsByTag("section");
        Elements links = content.select("a[class=link-type-hero]");
        System.out.println("-----------------------");
        System.out.println(links);
    }
}
