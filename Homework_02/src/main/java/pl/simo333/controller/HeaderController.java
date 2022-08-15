package pl.simo333.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HeaderController {

    @GetMapping("/showUserAgent")
    public String showUserAgent(@RequestHeader(value = "User-Agent") String userAgent,
                                HttpServletRequest request) {
        request.setAttribute("userAgent", userAgent);
        return "userAgent";
    }

}
