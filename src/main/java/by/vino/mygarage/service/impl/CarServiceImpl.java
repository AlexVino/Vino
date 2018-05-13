package by.vino.mygarage.service.impl;

import by.vino.mygarage.dao.api.CarRepository;
import by.vino.mygarage.dao.jpa.Car;
import by.vino.mygarage.rest.dto.BaseCarDto;
import by.vino.mygarage.service.api.CarService;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private MessageSource messageSource;

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
    public BaseCarDto get(int carId, Locale locale) {
        return toDto(carRepository.findById(carId).orElse(null), locale);
    }

    @Override
    public List<BaseCarDto> getAll(Predicate predicate, Pageable pageable, Locale locale) {
        return toDtoList(carRepository.findAll(predicate, pageable), locale);
    }

    private List<BaseCarDto> toDtoList(Iterable<Car> cars, Locale locale) {
        List<BaseCarDto> list = new ArrayList<>();
        for (Car car : cars) {
            list.add(toDto(car, locale));
        }
        return list;
    }

    private BaseCarDto toDto(Car car, Locale locale) {
        if (car == null) {
            return null;
        }
        BaseCarDto dto = new BaseCarDto();
        dto.setCarId(car.getCarId());
        dto.setFullModel(String.format("%s %s",
                car.getModel().getMake().getMakeName(),
                car.getModel().getModelName()));
        dto.setModel(car.getModel().getModelName());
        dto.setPrice(car.getPrice());
        dto.setBodystyle(car.getBodystyle().getBodystyleName());
        dto.setBodystyleLocal(messageSource.getMessage("search.bodystyle." + car.getBodystyle().getBodystyleName(), null, locale));
        dto.setYear(car.getYear());
        dto.setMileage(car.getMileage());
        dto.setTransmission(car.getTransmission().getTransmissionName());
        dto.setTransmissionLocal(messageSource.getMessage("search.transmission." + car.getTransmission().getTransmissionName(), null, locale));
        dto.setFuelType(car.getFuelType().getFuelTypeName());
        dto.setFuelTypeLocal(messageSource.getMessage("search.fuel_type." + car.getFuelType().getFuelTypeName(), null, locale));
        dto.setColor(car.getColor().getColorName());
        dto.setImage(car.getImage());
        dto.setDescription(car.getDescription());
        dto.setEngine(car.getEngine());
        return dto;
    }
}
