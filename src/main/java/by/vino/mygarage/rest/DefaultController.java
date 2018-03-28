package by.vino.mygarage.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {

    @GetMapping("/")
    public String home1() {
        return home();
    }

    @GetMapping("/index")
    public String home() {
        return "/index";
    }

    @GetMapping("/signUp")
    public String signUp() {
        return "/signUp";
    }

}