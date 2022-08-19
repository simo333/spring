package pl.simo333;

import pl.simo333.model.Hero;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MainHero {
    public static void main(String[] args) {
        List<Hero> heroes = new ArrayList<>(List.of(
                new Hero("Spider-Man", 100L, LocalDate.of(1990, 5, 20), "123456789"),
                new Hero("Robo-Cop", 30L, LocalDate.of(1950, 3, 12), "123456789"),
                new Hero("Hulk", 300L, LocalDate.of(1960, 6, 26), "123456789"),
                new Hero("Iron Man", 140L, LocalDate.of(2000, 1, 15), "123456789"),
                new Hero("Thor", 175L, LocalDate.of(2010, 4, 25), "123456789")
//                new Hero("T", null, LocalDate.of(2010, 4, 25), "123456789")
        ));

        heroes.stream()
                .filter(hero -> hero.getName().matches(".u.*"))
                .filter(hero -> hero.getPower() > 5)
                .forEach(System.out::println);
        System.out.println();

        heroes.stream()
                .sorted()
                .forEach(System.out::println);
        System.out.println();

        heroes.stream()
                .map(Hero::getName)
                .forEach(System.out::println);

        heroes.stream()
                .peek(hero -> hero.setName(hero.getName().substring(0, 1).toUpperCase()))
                .forEach(System.out::println);
        System.out.println();

        String s = heroes.stream()
                .map(hero -> hero.getName().substring(0, 1).toUpperCase())
                .reduce((a, b) -> String.join("-", a, b))
                .orElseThrow(() -> new IllegalStateException("Not found."));
        System.out.println(s);
    }
}
