package pl.simo333.task5;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class CookieController {
    @GetMapping("add-cookies")
    @ResponseBody
    public String addCookies(HttpServletResponse response) {
        Cookie cookie1 = new Cookie("user", "Jan");
        cookie1.setMaxAge(60 * 10);
        Cookie cookie2 = new Cookie("uid", "ccb1b154-c4ff");
        cookie1.setMaxAge(60 * 60 * 24 * 10);
        Cookie cookie3 = new Cookie("IDE", "IntelliJ");
        cookie1.setMaxAge(60 * 60 * 24 * 30);
        response.addCookie(cookie1);
        response.addCookie(cookie2);
        response.addCookie(cookie3);
        return "Cookies added.";
    }
}
