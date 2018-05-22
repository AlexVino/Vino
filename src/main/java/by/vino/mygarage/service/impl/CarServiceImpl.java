package by.vino.mygarage.service.impl;

import by.vino.mygarage.dao.api.BodyStyleRepository;
import by.vino.mygarage.dao.api.CarRepository;
import by.vino.mygarage.dao.api.ColorRepository;
import by.vino.mygarage.dao.api.FuelTypeRepository;
import by.vino.mygarage.dao.api.ModelRepository;
import by.vino.mygarage.dao.api.TransmissionRepository;
import by.vino.mygarage.dao.jpa.Bodystyle;
import by.vino.mygarage.dao.jpa.Car;
import by.vino.mygarage.dao.jpa.Color;
import by.vino.mygarage.dao.jpa.FuelType;
import by.vino.mygarage.dao.jpa.Model;
import by.vino.mygarage.dao.jpa.Transmission;
import by.vino.mygarage.exception.ErrorCode;
import by.vino.mygarage.exception.RestException;
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
    private ModelRepository modelRepository;
    @Autowired
    private BodyStyleRepository bodyStyleRepository;
    @Autowired
    private TransmissionRepository transmissionRepository;
    @Autowired
    private FuelTypeRepository fuelTypeRepository;
    @Autowired
    private ColorRepository colorRepository;
    @Autowired
    private MessageSource messageSource;

    @Override
    public BaseCarDto create(BaseCarDto dto, Locale locale) {
        return toDto(carRepository.save(toEntity(dto)), locale);
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

     private Car toEntity(BaseCarDto dto) {
         Model model = modelRepository.findByModelNameIgnoreCaseAndMake_MakeNameIgnoreCase(dto.getModel(), dto.getMake());
         if (model == null) {
             throw new RestException(ErrorCode.MODEL_DOES_NOT_EXIST);
         }
         Bodystyle bodystyle = bodyStyleRepository.findByBodystyleNameIgnoreCase(dto.getBodystyle());
         if (bodystyle == null) {
             throw new RestException(ErrorCode.BODYSTYLE_DOES_NOT_EXIST);
         }
         Transmission transmission = transmissionRepository.findByTransmissionNameIgnoreCase(dto.getTransmission());
         if (transmission == null) {
             throw new RestException(ErrorCode.TRANSMISSION_DOES_NOT_EXIST);
         }
         FuelType fuelType = fuelTypeRepository.findByFuelTypeNameIgnoreCase(dto.getFuelType());
         if (fuelType == null) {
             throw new RestException(ErrorCode.FUELTYPE_DOES_NOT_EXIST);
         }
         Color color = colorRepository.findByColorNameIgnoreCase(dto.getColor());
         if (color == null) {
             throw new RestException(ErrorCode.COLOR_DOES_NOT_EXIST);
         }
         Car car = new Car();
         car.setCarId(dto.getCarId());
         car.setModel(model);
         car.setPrice(dto.getPrice());
         car.setBodystyle(bodystyle);
         car.setYear(dto.getYear());
         car.setMileage(dto.getMileage());
         car.setTransmission(transmission);
         car.setFuelType(fuelType);
         car.setColor(color);
         car.setImage(dto.getImage());
         car.setDescription(dto.getDescription());
         car.setEngine(dto.getEngine());
         return car;
     }
}
