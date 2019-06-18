package by.vino.mygarage.service.impl;

import by.vino.mygarage.dao.api.BodyStyleRepository;
import by.vino.mygarage.dao.api.CarRepository;
import by.vino.mygarage.dao.api.ColorRepository;
import by.vino.mygarage.dao.api.FuelTypeRepository;
import by.vino.mygarage.dao.api.ModelRepository;
import by.vino.mygarage.dao.api.OrderRepository;
import by.vino.mygarage.dao.api.DriveTypeRepository;
import by.vino.mygarage.dao.api.TransmissionRepository;
import by.vino.mygarage.dao.api.HeadlightsRepository;
import by.vino.mygarage.dao.api.ComplectationRepository;
import by.vino.mygarage.dao.api.AdRepository;
import by.vino.mygarage.dao.jpa.*;
import by.vino.mygarage.exception.ErrorCode;
import by.vino.mygarage.exception.RestException;
import by.vino.mygarage.rest.dto.BaseCarDto;
import by.vino.mygarage.service.api.CarService;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.IOException;
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
    private DriveTypeRepository driveTypeRepository;
    @Autowired
    private HeadlightsRepository headlightsRepository;
    @Autowired
    private MessageSource messageSource;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ComplectationRepository complectationRepository;
    @Autowired
    private AdRepository adRepository;

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
        /*if (orderRepository.findByCar_CarId(carId) != null){
            throw new RestException(ErrorCode.CAR_ALREADY_ORDERED);
        }
        carRepository.deleteById(carId);*/
    }

    @Override
    public BaseCarDto get(int carId, Locale locale) {
        return toDto(carRepository.findById(carId).orElse(null), locale);
    }

    @Override
    public List<BaseCarDto> getAll(Predicate predicate, Pageable pageable, Locale locale) {
        //return toDtoList(carRepository.findAll(predicate, pageable), locale);
        return toDtoList2(adRepository.findAll(predicate, pageable), locale);
    }

    private List<BaseCarDto> toDtoList(Iterable<Car> cars, Locale locale) {
        List<BaseCarDto> list = new ArrayList<>();
        for (Car car : cars) {
            list.add(toDto(car, locale));
        }
        return list;
    }

    private List<BaseCarDto> toDtoList2(Iterable<Ad> ads, Locale locale) {
        List<BaseCarDto> list = new ArrayList<>();
        List<Car> cars = new ArrayList<>();

        for (Ad ad : ads) {
            cars.add(ad.getCar());
        }
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
                car.getComplectation().getModel().getMake().getMakeName(),
                car.getComplectation().getModel().getModelName()));
        dto.setMake(car.getComplectation().getModel().getMake().getMakeName());
        dto.setModel(car.getComplectation().getModel().getModelName());
        dto.setPrice(car.getPrice());
        dto.setBodystyle(car.getComplectation().getBodystyle().getBodystyleName());
        dto.setBodystyleLocal(messageSource.getMessage("search.bodystyle." + car.getComplectation().getBodystyle().getBodystyleName(), null, locale));
        dto.setYear(car.getComplectation().getYear());
        dto.setMileage(car.getMileage());
        dto.setTransmission(car.getComplectation().getTransmission().getTransmissionName());
        dto.setTransmissionLocal(messageSource.getMessage("search.transmission." + car.getComplectation().getTransmission().getTransmissionName(), null, locale));
        dto.setFuelType(car.getComplectation().getFuelType().getFuelTypeName());
        dto.setFuelTypeLocal(messageSource.getMessage("search.fuel_type." + car.getComplectation().getFuelType().getFuelTypeName(), null, locale));
        dto.setColor(car.getColor().getColorName());
        dto.setImage(car.getImage());
        dto.setDescription(car.getDescription());
        dto.setEnginevolume(car.getComplectation().getEnginevolume());
        dto.setVin(car.getVin());
        dto.setRrPrice(car.getRrPrice());
        dto.setComplectationName(car.getComplectation().getComplectationName());
        dto.setDrivetype(car.getComplectation().getDrivetype().getDrivetypeName());
        dto.setDrivetypeLocal(messageSource.getMessage("search.drivetype." + car.getComplectation().getDrivetype().getDrivetypeName().toLowerCase(), null, locale));
        dto.setHorsepower(car.getComplectation().getHorsepower());
        dto.setAcceleration(car.getComplectation().getAcceleration());
        dto.setCommonconsumption(car.getComplectation().getCommonconsumption());
        dto.setCityconsumption(car.getComplectation().getCityconsumption());
        dto.setRouteconsumption(car.getComplectation().getRouteconsumption());
        dto.setLength(car.getComplectation().getLength());
        dto.setWidth(car.getComplectation().getWidth());
        dto.setMaxspeed(car.getComplectation().getMaxspeed());
        dto.setComplectationId(car.getComplectation().getComplectationId());
        dto.setHeadlight(car.getComplectation().getHeadlight().getHeadlightName());
        dto.setHeadlightLocal(messageSource.getMessage("search.headlights." + car.getComplectation().getHeadlight().getHeadlightName().toLowerCase(), null, locale));
        dto.setElectricheatingofthewindshield(car.getComplectation().isElectricheatingofthewindshield());
        dto.setElectricheatingofsidemirrors(car.getComplectation().isElectricheatingofsidemirrors());
        dto.setHeadlightwashersystem(car.getComplectation().isHeadlightwashersystem());
        dto.setRainsensor(car.getComplectation().isRainsensor());
        dto.setFoglight(car.getComplectation().isFoglight());
        dto.setBluetooth(car.getComplectation().isBluetooth());
        dto.setAux(car.getComplectation().isAux());
        dto.setUsb(car.getComplectation().isUsb());
        dto.setNavigationsystem(car.getComplectation().isNavigationsystem());
        dto.setCruisecontrol(car.getComplectation().isCruisecontrol());
        dto.setParktronic(car.getComplectation().isParktronic());
        dto.setClimatecontrol(car.getComplectation().isClimatecontrol());
        dto.setPowerWindows(car.getComplectation().isPowerWindows());
        dto.setSteeringadjustment(car.getComplectation().isSteeringadjustment());
        return dto;
    }

     private Car toEntity(BaseCarDto dto) {

         Color color = colorRepository.findByColorNameIgnoreCase(dto.getColor());
         if (color == null) {
             throw new RestException(ErrorCode.COLOR_DOES_NOT_EXIST);
         }

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

         Drivetype drivetype = driveTypeRepository.findByDrivetypeNameIgnoreCase(dto.getDrivetype());
         if (drivetype == null) {
             throw new RestException(ErrorCode.DRIVETYPE_DOES_NOT_EXIST);
         }

         Headlights headlights = headlightsRepository.findByHeadlightNameIgnoreCase(dto.getHeadlight());
         if (headlights == null) {
             throw new RestException(ErrorCode.HEADLIGHTS_DOES_NOT_EXIST);
         }
         /*Complectation complectation = complectationRepository.findById(dto.getComplectationId()).orElse(null);
         if (complectation == null) {
             throw new RestException(ErrorCode.COMPLECTATION_DOES_NOT_EXIST);
         }*/

         Complectation complectation = new Complectation();
         complectation.setAcceleration(dto.getAcceleration());
         complectation.setAux(dto.isAux());
         complectation.setBluetooth(dto.isBluetooth());
         complectation.setBodystyle(bodystyle);
         complectation.setCityconsumption(dto.getCityconsumption());
         complectation.setClimatecontrol(dto.isClimatecontrol());
         complectation.setCommonconsumption(dto.getCommonconsumption());
         complectation.setComplectationName(dto.getComplectationName());
         complectation.setCruisecontrol(dto.isCruisecontrol());
         complectation.setDrivetype(drivetype);
         complectation.setElectricheatingofsidemirrors(dto.isElectricheatingofsidemirrors());
         complectation.setElectricheatingofthewindshield(dto.isElectricheatingofthewindshield());
         complectation.setEnginevolume(dto.getEnginevolume());
         complectation.setFoglight(dto.isFoglight());
         complectation.setFuelType(fuelType);
         complectation.setHeadlight(headlights);
         complectation.setHeadlightwashersystem(dto.isHeadlightwashersystem());
         complectation.setHorsepower(dto.getHorsepower());
         complectation.setLength(dto.getLength());
         complectation.setMaxspeed(dto.getMaxspeed());
         complectation.setModel(model);
         complectation.setNavigationsystem(dto.isNavigationsystem());
         complectation.setParktronic(dto.isParktronic());
         complectation.setPowerWindows(dto.isPowerWindows());
         complectation.setRainsensor(dto.isRainsensor());
         complectation.setRouteconsumption(dto.getRouteconsumption());
         complectation.setSteeringadjustment(dto.isSteeringadjustment());
         complectation.setTransmission(transmission);
         complectation.setUsb(dto.isUsb());
         complectation.setWidth(dto.getWidth());
         complectation.setYear(dto.getYear());

         Car car = new Car();
         car.setCarId(dto.getCarId());
         car.setVin(dto.getVin());
         car.setRrPrice(dto.getRrPrice());
         car.setPrice(dto.getPrice());
         car.setMileage(dto.getMileage());
         car.setColor(color);
         car.setComplectation(complectationRepository.save(complectation));
         car.setImage(dto.getImage());
         car.setDescription(dto.getDescription());
         return car;
     }
}
