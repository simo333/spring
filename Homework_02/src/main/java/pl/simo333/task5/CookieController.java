package pl.simo333.task5;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

@Controller
public class CookieController {
    @GetMapping("/add-cookies")
    @ResponseBody
    public String addCookies(HttpServletResponse response) {
        Cookie cookie1 = new Cookie("user", "Jan");
        cookie1.setMaxAge(60 * 10);
        cookie1.setPath("/");
        Cookie cookie2 = new Cookie("uid", "ccb1b154-c4ff");
        cookie2.setMaxAge(60 * 60 * 24 * 10);
        cookie2.setPath("/");
        Cookie cookie3 = new Cookie("IDE", "IntelliJ");
        cookie3.setMaxAge(60 * 60 * 24 * 30);
        cookie3.setPath("/");
        response.addCookie(cookie1);
        response.addCookie(cookie2);
        response.addCookie(cookie3);
        return "Cookies added.";
    }

    @GetMapping("/all-cookies")
    public String allCookies(HttpServletRequest request) {
        List<Cookie> cookies = Arrays.asList(request.getCookies());
        request.setAttribute("cookies", cookies);
        return "task5/cookies";
    }
}
