package by.vino.mygarage.rest;

import by.vino.mygarage.dao.jpa.RoleEnum;
import by.vino.mygarage.rest.dto.BaseCarDto;
import by.vino.mygarage.service.api.AdService;
import by.vino.mygarage.service.api.CarService;
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
            modelAndView = new ModelAndView("/ad");
            modelAndView.addObject("ad", ad);
        } else {
            modelAndView = new ModelAndView("/error/404");
        }
        return modelAndView;
        /*BaseCarDto car = carService.get(id, locale);
        ModelAndView modelAndView;
        if (car != null) {
            modelAndView = new ModelAndView("/car");
            modelAndView.addObject("car", car);
        } else {
            modelAndView = new ModelAndView("/error/404");
        }
        return modelAndView;*/
    }

    @GetMapping("/orders")
    public String orders() {
        UserDetails user = securityHelper.getCurrentUser();
        if (user == null) {
            return "/signUp";
        }
        if (securityHelper.isRoleAuthority(user, RoleEnum.ROLE_ADMIN)) {
            return "/adminorders";
        } else {
            return "/orders";
        }
    }

    @GetMapping("/ads/create")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String createCar() {
            return "/ad.create";
    }

    @GetMapping("/ads/{id}/edit")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView editCar(@PathVariable("id") int id, Locale locale) {
        BaseCarDto ad = adService.get(id, locale);
        ModelAndView modelAndView;
        if (ad != null) {
            modelAndView = new ModelAndView("/ad.edit");
            modelAndView.addObject("ad", ad);
        } else {
            modelAndView = new ModelAndView("/error/404");
        }
        return modelAndView;
    }
}