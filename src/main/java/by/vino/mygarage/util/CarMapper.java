package by.vino.mygarage.util;

import by.vino.mygarage.dao.jpa.Car;
import by.vino.mygarage.rest.dto.BaseCarDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarMapper {
    public List<BaseCarDto> toDtoList(List<Car> cars) {
        List<BaseCarDto> list = new ArrayList<>();
        for (Car car : cars) {
            list.add(toDto(car));
        }
        return list;
    }

    public BaseCarDto toDto(Car car) {
        BaseCarDto dto = new BaseCarDto();
        dto.setCarId(car.getCarId());
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
