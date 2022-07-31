package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
}
