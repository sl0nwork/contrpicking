package startWeb;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;


public class HtmlParser {

    String url = "https://ru.dotabuff.com/heroes";

    HtmlParser(String heroName) {
        url = url + "/" + heroName;
    }

    HashMap<String, String> parseHeroMap() throws IOException {
        String repImgUrl = "https://ru.dotabuff.com";
        HashMap<String, String> heroMap = new HashMap<String, String>();
        String urlHeroGrid = "https://ru.dotabuff.com/heroes";
        Document doc = Jsoup.connect(urlHeroGrid).get();
        Elements target = doc.getElementsByAttributeValueStarting("style", "background: url");
        String style;
        for (Element e : target) {
            style = e.attr("style");
            style = repImgUrl + style.substring(16, style.length() - 1);
            String heroName = e.text();
            heroName = heroName.replaceAll(" ", "-");
            heroName = heroName.toLowerCase();
            heroMap.put(heroName, style);
        }
        return heroMap;
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
        String result = "";
        for (Element e : links) {
            result = result + e.text() + " ";
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        HtmlParser parser = new HtmlParser("puck");
        parser.parseHeroMap();
    }
}
