package by.vino.mygarage.service.impl;

import by.vino.mygarage.dao.api.CarRepository;
import by.vino.mygarage.dao.jpa.Car;
import by.vino.mygarage.rest.dto.BaseCarDto;
import by.vino.mygarage.service.api.CarService;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarRepository carRepository;

    @Override
    public Car create(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car update(Car car) {
        return carRepository.save(car);
    }

    @Override
    public void remove(int carId) {
        carRepository.deleteById(carId);
    }

    @Override
    public BaseCarDto get(int carId) {
        return toDto(carRepository.findById(carId).orElse(null));
    }

    @Override
    public List<BaseCarDto> getAll(Predicate predicate, Pageable pageable) {
        return toDtoList(carRepository.findAll(predicate, pageable));
    }

    private List<BaseCarDto> toDtoList(Iterable<Car> cars) {
        List<BaseCarDto> list = new ArrayList<>();
        for (Car car : cars) {
            list.add(toDto(car));
        }
        return list;
    }

    private BaseCarDto toDto(Car car) {
        BaseCarDto dto = new BaseCarDto();
        dto.setCarId(car.getCarId());
        dto.setFullModel(String.format("%s %s",
                car.getModel().getMake().getMakeName(),
                car.getModel().getModelName()));
        dto.setModel(car.getModel().getModelName());
        dto.setPrice(car.getPrice());
        dto.setBodystyle(car.getBodystyle().getBodystyleName());
        dto.setYear(car.getYear());
        dto.setMileage(car.getMileage());
        dto.setTransmission(car.getTransmission().getTransmissionName());
        dto.setFuelType(car.getFuelType().getFuelTypeName());
        dto.setColor(car.getColor().getColorName());
        return dto;
    }
}
