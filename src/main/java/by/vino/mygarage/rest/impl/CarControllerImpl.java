package by.vino.mygarage.rest.impl;

import by.vino.mygarage.dao.api.CarRepository;
import by.vino.mygarage.dao.jpa.Car;
import by.vino.mygarage.dao.jpa.QCar;
import by.vino.mygarage.rest.dto.BaseCarDto;
import by.vino.mygarage.rest.dto.QBaseCarDto;
import by.vino.mygarage.rest.dto.SearchCarDto;
import by.vino.mygarage.service.api.CarService;
import by.vino.mygarage.util.CarMapper;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.PredicateTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.data.querydsl.binding.QuerydslPredicateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.awt.print.Pageable;
import java.util.List;

@RestController
@RequestMapping("/rest/cars")
public class CarControllerImpl {

    @Autowired
    private CarRepository carRepository;
    @Autowired
    private CarMapper carMapper;

    /**
     * Processes GET request to '/rest/cars' and
     * returns all car by filter and sort.
     *
     * @return list of cars
     * */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> listCars(@QuerydslPredicate(root = Car.class) Predicate predicate) {
        Iterable<Car> all = carRepository.findAll(predicate);
        return ResponseEntity.ok(carMapper.toDtoList(all));
    }

}