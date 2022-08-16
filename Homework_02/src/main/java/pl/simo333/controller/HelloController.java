package pl.simo333.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.util.stream.Stream;

@Controller
public class HelloController {

    @GetMapping("/workers")
    public String workersAction(HttpServletRequest request) {
        int random = new Random().nextInt(1, 31);
        System.out.println("Found random: " + random);
        try (Stream<String> lines = Files.lines(Paths.get("C:\\Users\\SimoPc\\IdeaProjects\\spring-configurations\\spring-configurations\\Homework_02\\Workers.txt"))) {
            lines.filter(line -> line.contains(String.valueOf(random)))
                    .forEach(line -> request.setAttribute("worker", line));
        } catch (IOException e) {
            System.out.println("Could not read file.");
        }
        return "workers";
    }
}
