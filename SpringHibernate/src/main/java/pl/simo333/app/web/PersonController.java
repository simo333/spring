package pl.simo333.app.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.simo333.app.domain.Person;
import pl.simo333.app.domain.PersonDetails;
import pl.simo333.app.service.PersonDetailsService;
import pl.simo333.app.service.PersonService;

@Controller
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;
    private final PersonDetailsService personDetailsService;

    public PersonController(PersonService personService, PersonDetailsService personDetailsService) {
        this.personService = personService;
        this.personDetailsService = personDetailsService;
    }

    @RequestMapping("/add")
    @ResponseBody
    public String add() {
        Person person = new Person();
        person.setLogin("John");
        person.setPassword("pw");
        person.setEmail("mail@mail.com");

        PersonDetails personDetails = new PersonDetails();
        personDetails.setFirstName("NamePersonController");
        personDetails.setLastName("LastNamePersonController");
        PersonDetails saved = personDetailsService.save(personDetails);

        person.setPersonDetails(saved);
        personService.save(person);
        return "Id dodanej osoby to: " + person.getId();
    }

    @RequestMapping("/get/{id}")
    @ResponseBody
    public String getOne(@PathVariable long id) {
        Person person = personService.findById(id);
        return person.toString();
    }

    @RequestMapping("/update/{id}/{login}/{password}")
    @ResponseBody
    public String update(@PathVariable long id, @PathVariable String login, @PathVariable String password) {
        Person person = personService.findById(id);
        person.setLogin(login);
        person.setPassword(password);
        personService.update(person);
        return person.toString();
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String deleteById(@PathVariable long id) {
        personService.delete(id);
        return "deleted";
    }

    @GetMapping("/form")
    public String getForm(Model model) {
        model.addAttribute("person", new Person());
        return "form/person";
    }

    @PostMapping("/form")
    @ResponseBody
    public String savePerson(Person person) {
        PersonDetails personDetails = new PersonDetails();
        personDetails.setFirstName("NamePersonController");
        personDetails.setLastName("LastNamePersonController");
        PersonDetails saved = personDetailsService.save(personDetails);
        person.setPersonDetails(saved);
        personService.save(person);
        return "added";
    }


}