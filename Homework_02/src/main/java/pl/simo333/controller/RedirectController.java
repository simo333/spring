package pl.simo333.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectController {

    @GetMapping("/first")
    public String first() {
        return "first";
    }

    @GetMapping("/second")
    public String second() {
        return "third";
    }

    @GetMapping("/third")
    public String third() {
        return "third";
    }
}
