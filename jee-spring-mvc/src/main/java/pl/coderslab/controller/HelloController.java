package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;

@Controller
public class HelloController {

    @GetMapping("/hello")
    @ResponseBody
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/hello/{firstName}/{lastName}")
    @ResponseBody
    public String hello(@PathVariable String firstName, @PathVariable String lastName) {
        return String.format("Witaj %s %s", firstName, lastName);
    }

    @GetMapping("/form")
    public String hello() {
        return "index";
    }

    @PostMapping("/form")
    @ResponseBody
    public String processForm(@RequestParam String paramName, @RequestParam String paramDate) {
        return paramName + paramDate;
    }

    @GetMapping("/helloView/{color}/{bgColor}")
    public String helloView(@PathVariable String bgColor, @PathVariable String color, Model model) {
        model.addAttribute("bgColor", bgColor);
        model.addAttribute("color", color);
        return "home";
    }

    @GetMapping("/helloView/")
    public String helloView(Model model) {
        LocalTime time = LocalTime.now();
        LocalTime start = LocalTime.of(8, 0);
        LocalTime end = LocalTime.of(20, 0);
        LocalTime nightTime = LocalTime.of(1, 0);
        if (time.isAfter(start) && time.isBefore(end)) {
            model.addAttribute("color", "black");
            model.addAttribute("bgColor", "white");
        } else {
            model.addAttribute("color", "white");
            model.addAttribute("bgColor", "black");
        }
        return "home";
    }
}
