package pl.coderslab.model.task4;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class CookieController {

    @GetMapping("/setcookie/{value1}/{value2}")
    @ResponseBody
    public String setCookie(@PathVariable String value1,
                          @PathVariable String value2,
                          HttpServletResponse response) {
        Cookie cookie1 = new Cookie("cookie1", value1);
        Cookie cookie2 = new Cookie("cookie2", value2);
        cookie1.setMaxAge(120);
        cookie1.setPath("/");
        cookie2.setMaxAge(120);
        cookie2.setPath("/");

        response.addCookie(cookie1);
        response.addCookie(cookie2);
        return "Cookies has been set.";
    }

    @GetMapping("/getcookie-v1")
    @ResponseBody
    public String getCookiesV1(HttpServletRequest request) {
        Cookie cookie1 = WebUtils.getCookie(request, "cookie1");
        Cookie cookie2 = WebUtils.getCookie(request, "cookie2");
        assert cookie1 != null : "cookie1 is null";
        assert cookie2 != null : "cookie2 is null";
        return "COOKIES: " + cookie1.getValue() + " " + cookie2.getValue();
    }

    @GetMapping("/getcookie-v2")
    @ResponseBody
    public String getCookiesV2(@CookieValue("cookie1") String cookie1,
                               @CookieValue("cookie2") String cookie2) {
        return "COOKIES: " + cookie1 + " " + cookie2;
    }


}
