package by.vino.mygarage.service.api;

import by.vino.mygarage.dao.jpa.Car;
import com.kumuluz.ee.rest.beans.QueryParameters;

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
     * Loads list of cars.
     *
     * @param query query parameters
     * */
    List<Car> list(QueryParameters query);

}
