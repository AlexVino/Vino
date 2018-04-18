package by.vino.mygarage.service.api;

import by.vino.mygarage.dao.jpa.Car;
import by.vino.mygarage.rest.dto.BaseCarDto;
import by.vino.mygarage.rest.dto.SearchCarDto;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CarService {
    /**
     * Creates new car.
     *
     * @param car car
     * */
    Car create(Car car);

    /**
     * Updates car.
     *
     * @param car car
     * */
    Car update(Car car);

    /**
     * Removes car.
     *
     * @param carId car id
     * */
    void remove(int carId);

    /**
     * Load a car.
     *
     * @param carId car id
     * */
    Car get(int carId);

    /**
     * Loads list of cars by searching params.
     *
     * @param predicate search entity
     * @param pageable page, size
     */
    List<BaseCarDto> getAll(Predicate predicate, Pageable pageable);
}
