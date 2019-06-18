package by.vino.mygarage.rest;

import by.vino.mygarage.dao.jpa.RoleEnum;
import by.vino.mygarage.dao.jpa.User;
import by.vino.mygarage.rest.dto.BaseCarDto;
import by.vino.mygarage.service.api.AdService;
import by.vino.mygarage.service.api.CarService;
import by.vino.mygarage.service.api.UserService;
import by.vino.mygarage.util.SecurityHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.Locale;

@Controller
public class DefaultController {

    @Autowired
    private AdService adService;
    @Autowired
    private UserService userService;
    @Autowired
    private SecurityHelper securityHelper;

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

    @GetMapping("/ads/{id}")
    public ModelAndView car(@PathVariable("id") int id, Locale locale) {
        BaseCarDto ad = adService.get(id, locale);
        ModelAndView modelAndView;
        if (ad != null) {
            modelAndView = new ModelAndView("/car");
            modelAndView.addObject("car", ad);
        } else {
            modelAndView = new ModelAndView("/error/404");
        }
        return modelAndView;
    }

    @GetMapping("/orders")
    public String orders() {
        UserDetails user = securityHelper.getCurrentUser();
        if (user == null) {
            return "/signUp";
        }
        if (securityHelper.isRoleAuthority(user, RoleEnum.ROLE_DEALER)){
            return "/adminorders";
        } else {
            return "/orders";
        }
    }

    @GetMapping("/dealers")
    public String dealers() {
        UserDetails user = securityHelper.getCurrentUser();
        if (user == null) {
            return "/signUp";
        }
        if (securityHelper.isRoleAuthority(user, RoleEnum.ROLE_ADMIN)) {
            return "/dealers";
        }else {
            return "/";
        }
    }

    @GetMapping("/dealers/create")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String createDealer() {
        return "/dealer.create";
    }

    @GetMapping("/dealers/{id}")
    public ModelAndView dealer(@PathVariable("id") int id, Locale locale) {
        User user = userService.loadUserById(id);
        ModelAndView modelAndView;
        if (user != null) {
            modelAndView = new ModelAndView("/dealer");
            modelAndView.addObject("user", user);
        } else {
            modelAndView = new ModelAndView("/error/404");
        }
        return modelAndView;
    }

    @GetMapping("/dealers/{id}/edit")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView editDealer(@PathVariable("id") int id, Locale locale) {
        User user = userService.loadUserById(id);
        ModelAndView modelAndView;
        if (user != null) {
            modelAndView = new ModelAndView("/dealer.edit");
            modelAndView.addObject("user", user);
        } else {
            modelAndView = new ModelAndView("/error/404");
        }
        return modelAndView;
    }


    @GetMapping("/ads/create")
    @PreAuthorize("hasRole('ROLE_ADMIN') || hasRole('ROLE_USER') || hasRole('ROLE_DEALER')")
    public String createCar() {
            return "/car.create";
    }

    @GetMapping("/ads/{id}/edit")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView editCar(@PathVariable("id") int id, Locale locale) {
        BaseCarDto ad = adService.get(id, locale);
        ModelAndView modelAndView;
        if (ad != null) {
            modelAndView = new ModelAndView("/car.edit");
            modelAndView.addObject("car", ad);
        } else {
            modelAndView = new ModelAndView("/error/404");
        }
        return modelAndView;
    }
}