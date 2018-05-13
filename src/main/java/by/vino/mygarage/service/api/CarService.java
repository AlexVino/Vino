package by.vino.mygarage.service.api;

import by.vino.mygarage.dao.jpa.Car;
import by.vino.mygarage.rest.dto.BaseCarDto;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Locale;

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
    BaseCarDto get(int carId, Locale locale);

    /**
     * Loads list of cars by searching params.
     *
     * @param predicate search entity
     * @param pageable page, size
     */
    List<BaseCarDto> getAll(Predicate predicate, Pageable pageable, Locale locale);
}
