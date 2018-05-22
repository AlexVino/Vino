package by.vino.mygarage.rest.impl;

import by.vino.mygarage.dao.jpa.Car;
import by.vino.mygarage.rest.dto.BaseCarDto;
import by.vino.mygarage.service.api.CarService;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Locale;

@RestController
@RequestMapping("/rest/cars")
public class CarControllerImpl {

    @Autowired
    private CarService carService;

    /**
     * Processes GET request to '/rest/cars' and
     * returns all car by filter and sort.
     *
     * @return list of cars
     * */
    @GetMapping
    public ResponseEntity<?> listCars(
            @QuerydslPredicate(root = Car.class) Predicate predicate, Pageable pageable, Locale locale) {
        return ResponseEntity.ok(carService.getAll(predicate, pageable, locale));
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> addCar(@Valid @RequestBody BaseCarDto dto, Locale locale) {
        return ResponseEntity.ok(carService.create(dto, locale));
    }


}