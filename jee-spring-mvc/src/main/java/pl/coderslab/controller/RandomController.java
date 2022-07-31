package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
public class RandomController {

    @GetMapping("/show-random")
    @ResponseBody
    public String showRandom() {
        Random random = new Random();
        return "Wylosowano liczbę: " + random.nextInt(1, 101);
    }

    @GetMapping("/random/{min:\\d+}/{max:\\d+}")
    @ResponseBody
    public String showRandomWithMax(@PathVariable int min, @PathVariable int max) {
        Random r = new Random();
        int rand = r.nextInt(min, max + 1);
        return String.format("Użytkownik podał wartości %d i %d. Wylosowano liczbę: %d.", min, max, rand);
    }

    @GetMapping("/header")
    @ResponseBody
    public String header(@RequestHeader("user-agent") String userAgent) {
        return userAgent;
    }
}
