package by.vino.mygarage.rest;

import by.vino.mygarage.service.api.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DefaultController {

    @Autowired
    private CarService carService;

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

    @GetMapping("/cars/{id}")
    public ModelAndView car(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("/car");
        modelAndView.addObject("car", carService.get(id));
        return modelAndView;
    }

    @GetMapping("/orders")
    public String orders() {
        return "/orders";
    }
}