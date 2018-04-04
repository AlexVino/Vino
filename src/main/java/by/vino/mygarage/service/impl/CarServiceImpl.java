package by.vino.mygarage.service.impl;

import by.vino.mygarage.dao.api.CarDao;
import by.vino.mygarage.dao.jpa.Car;
import by.vino.mygarage.service.api.CarService;
import com.kumuluz.ee.rest.beans.QueryParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarDao carDao;

    @Override
    public Car create(Car car) {
        return carDao.create(car);
    }

    @Override
    public Car update(Car car) {
        return carDao.update(car);
    }

    @Override
    public void remove(int carId) {
        Car car = carDao.get(carId);
        carDao.delete(car);
    }

    @Override
    public Car get(int carId) {
        return carDao.get(carId);
    }

    @Override
    public List<Car> list(QueryParameters query) {
        return carDao.getAll();
    }
}
