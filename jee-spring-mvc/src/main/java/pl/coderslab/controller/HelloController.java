package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/first")
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
        return "index.jsp";
    }

    @PostMapping("/form")
    @ResponseBody
    public String processForm(@RequestParam String paramName, @RequestParam String paramDate) {
        return paramName + paramDate;
    }
}
