package pl.simo333;

import org.springframework.stereotype.Component;
import pl.simo333.model.Hero;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class HeroComponent {
    private List<Hero> heroList = new ArrayList<>();

    public void addHero(Hero hero) {
        heroList.add(hero);
    }

    public List<Hero> getHeroList() {
        return heroList;
    }

    public Optional<Hero> findHeroByPhoneNumber(String phoneNumber) {
        return heroList.stream()
                .filter(hero -> phoneNumber.equals(hero.getPhone()))
                .findFirst();
    }

}
