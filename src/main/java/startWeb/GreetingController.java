package startWeb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.HTML;
import java.io.IOException;
import java.util.HashMap;

@Controller
public class GreetingController {

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public String greetingForm(Model model) throws IOException {
        Greeting greeting = new Greeting();
        HtmlParser parser = new HtmlParser("");
        HashMap<String, String> heroMap = parser.parseHeroMap();
        greeting.setMap(heroMap);
        model.addAttribute("greeting", greeting);
        return "greeting";
    }


    @RequestMapping(value = "/greeting", method = RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute Greeting greeting, Model model) {
        model.addAttribute("greeting", greeting);
        return "result";
    }

    @RequestMapping(value = "/greeting/{hero}", method = RequestMethod.GET)
    public String heroPage(Model model, @PathVariable String hero) throws IOException {

        HtmlParser parser = new HtmlParser(hero);
        String contrpicking = parser.parse();
        Greeting greeting = new Greeting();
        greeting.setContent(contrpicking);
        model.addAttribute("greeting", greeting);
        return "resultHero";
    }
}