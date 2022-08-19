package pl.simo333.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.simo333.HeroComponent;
import pl.simo333.model.Hero;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.Arrays;

@Controller
public class ExamController {

    private final HeroComponent heroComponent;

    public ExamController(HeroComponent heroComponent) {
        this.heroComponent = heroComponent;
    }

    @GetMapping("/add-hero")
    public String addHeroForm() {
        return "addHero";
    }

    @PostMapping("/add-hero")
    public String addHero(@RequestParam("name") String name,
                          @RequestParam("power") Long power,
                          @RequestParam("dateOfBirth") String date,
                          @RequestParam("phoneNumber") String phoneNumber,
                          HttpServletRequest request) {
        String[] dateStringArray = date.split("-");
        Integer[] dateIntArray = Arrays.stream(dateStringArray)
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
        LocalDate dateOfBirth = LocalDate.of(dateIntArray[0], dateIntArray[1], dateIntArray[2]);
        heroComponent.addHero(new Hero(name, power, dateOfBirth, phoneNumber));
        request.setAttribute("heroes", heroComponent.getHeroList());
        return "addHero";
    }
}
