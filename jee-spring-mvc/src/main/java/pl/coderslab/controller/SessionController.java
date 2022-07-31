package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

import static pl.coderslab.controller.SessionController.FIELD_NAME;

@Controller
@SessionAttributes(FIELD_NAME)
public class SessionController {

    public static final String FIELD_NAME = "loginStart";

    @GetMapping("/session")
    @ResponseBody
    public String getLoginStart(Model model, HttpSession session) {
        LocalDateTime loginStart = (LocalDateTime) model.getAttribute(FIELD_NAME);
        if (loginStart == null) {
            loginStart = LocalDateTime.now();
            model.addAttribute(FIELD_NAME, loginStart);
        }
        return loginStart.toString();
    }
}
