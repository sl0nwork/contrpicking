package startWeb;

import java.util.HashMap;

public class Greeting {

    private long id;
    private String content;
    private HashMap<String, String> heroMap;

    public void setMap(HashMap<String, String> hMap) {
        heroMap = hMap;
    }

    public HashMap<String, String> getMap() {
        return heroMap;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}