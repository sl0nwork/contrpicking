package startWeb;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class HtmlParser {

    String url = "";
    String heroName = "";

    HtmlParser(String url, String heroName) {
        this.url = url;
        this.heroName = heroName;
    }

    String parse() throws IOException {
        //Load a Doc from a Url
        Document doc = Jsoup.connect(url).get();
        Elements content = doc.getElementsByTag("section");
        Elements targetSection = null;
        for (Element e : content) {
            targetSection = e.select("section:contains(Слаб против)");
            if (targetSection.size() > 0) {
                break;
            }
        }
        if (targetSection == null || targetSection.size() == 0) {
            System.out.println("couldn't find section");
            return "couldn`t find section";
        }

        Element element = targetSection.get(0);
        Elements links = targetSection.select("a[class=link-type-hero]");
        System.out.println("-----------------------");
        String result = "";
        for (Element e : links) {
            result = result + e.text() + " ";
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
    }
}
