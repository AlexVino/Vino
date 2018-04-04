package by.vino.mygarage.rest.impl;

import by.vino.mygarage.dao.jpa.Car;
import by.vino.mygarage.service.api.CarService;
import by.vino.mygarage.util.CarMapper;
import com.kumuluz.ee.rest.beans.QueryParameters;
import com.kumuluz.ee.rest.utils.QueryStringDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/rest/cars")
public class CarControllerImpl {
    @Autowired
    private CarMapper carMapper;
    @Autowired
    private CarService carService;
    @Autowired
    private QueryStringDefaults qsd;
    /**
     * Processes GET request to '/rest/cars' and
     * returns all car by filter and sort.
     *
     * @return list of cars
     * */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> listCars() {
        String s = ServletUriComponentsBuilder.fromCurrentRequest().build().getQuery();
        QueryParameters queryParameters = qsd.builder().queryEncoded(s).build();
        List<Car> cars = carService.list(queryParameters);
        return ResponseEntity.ok(carMapper.toDtoList(cars));
    }

}