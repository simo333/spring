package pl.simo333.app.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.simo333.app.dao.Student;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @GetMapping("/form")
    public String getForm(Model model) {
        model.addAttribute(new Student());
        return "form/studentForm";
    }

    @PostMapping("/form")
    @ResponseBody
    public String processForm(Student student) {

        return student.toString();
    }

    @ModelAttribute("countries")
    public List<String> countries() {
        return Arrays.asList("Poland", "Germany", "France", "Russia", "Denmark");
    }

    @ModelAttribute("hobbies")
    public List<String> hobbies() {
        return Arrays.asList("Football", "Gaming", "Volleyball", "Piano", "Jogging");
    }

    @ModelAttribute("programmingSkills")
    public List<String> programmingSkills() {
        return Arrays.asList("Java", "Python", "JS", "Ruby", "Php");
    }



}
