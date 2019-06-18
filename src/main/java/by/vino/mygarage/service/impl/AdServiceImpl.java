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
import by.vino.mygarage.util.SecurityHelper;
import by.vino.mygarage.exception.ErrorCode;
import by.vino.mygarage.exception.RestException;
import by.vino.mygarage.rest.dto.BaseCarDto;
import by.vino.mygarage.service.api.AdService;
import by.vino.mygarage.service.api.CarService;
import by.vino.mygarage.service.api.UserService;
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
public class AdServiceImpl implements AdService {

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
    @Autowired
    private UserService userService;
    @Autowired
    private SecurityHelper securityHelper;

    @Override
    public BaseCarDto create(BaseCarDto dto, Locale locale) {
        //return adRepository.save(toEntity(dto, locale));
        return toDto(adRepository.save(toEntity(dto)), locale);
    }

    @Override
    public Ad update(Ad ad) {

        //return carRepository.save(car);
        return adRepository.save(ad); ///////// НЕ ИСПОЛЬЗУЕТСЯ
    }

    @Override
    public void remove(int adId) {
        Ad ad = adRepository.findById(adId).get();
        java.util.Date date = new java.util.Date();
        ad.setDateDelete(date);
        adRepository.save(ad);

        /*if (orderRepository.findByCar_CarId(adId) != null){
            throw new RestException(ErrorCode.CAR_ALREADY_ORDERED);
        }
        carRepository.deleteById(adId);*/
    }

    @Override
    public BaseCarDto get(int adId, Locale locale) {
        BaseCarDto dto = toDto(adRepository.findById(adId).orElse(null), locale);
        return dto;
        //return toDto(carRepository.findById(carId).orElse(null), locale);
    }

    @Override
    public List<BaseCarDto> getAll(Predicate predicate, Pageable pageable, Locale locale) {
        //return toDtoList(carRepository.findAll(predicate, pageable), locale);
        return toDtoList2(adRepository.findAll(predicate, pageable), locale);
    }

    /*private List<BaseCarDto> toDtoList(Iterable<Car> cars, Locale locale) {
        List<BaseCarDto> list = new ArrayList<>();
        for (Car car : cars) {
            list.add(toDto(car, locale));
        }
        return list;
    }*/

    private List<BaseCarDto> toDtoList2(Iterable<Ad> ads, Locale locale) {
        List<BaseCarDto> list = new ArrayList<>();

        for (Ad ad : ads) {
            list.add(toDto(ad, locale));
        }

        return list;
    }

    private BaseCarDto toDto(Ad ad, Locale locale) {
        if (ad == null) {
            return null;
        }
        BaseCarDto dto = new BaseCarDto();

        dto.setAdId(ad.getAdId());
        dto.setDateAdd(ad.getDateAdd());
        dto.setDateDelete(ad.getDateDelete());
        dto.setUserId(ad.getUser().getUserId());

        dto.setCarId(ad.getCar().getCarId());
        dto.setFullModel(String.format("%s %s",
                ad.getCar().getComplectation().getModel().getMake().getMakeName(),
                ad.getCar().getComplectation().getModel().getModelName()));
        dto.setMake(ad.getCar().getComplectation().getModel().getMake().getMakeName());
        dto.setModel(ad.getCar().getComplectation().getModel().getModelName());
        dto.setPrice(ad.getCar().getPrice());
        dto.setBodystyle(ad.getCar().getComplectation().getBodystyle().getBodystyleName());
        dto.setBodystyleLocal(messageSource.getMessage("search.bodystyle." + ad.getCar().getComplectation().getBodystyle().getBodystyleName(), null, locale));
        dto.setYear(ad.getCar().getComplectation().getYear());
        dto.setMileage(ad.getCar().getMileage());
        dto.setTransmission(ad.getCar().getComplectation().getTransmission().getTransmissionName());
        dto.setTransmissionLocal(messageSource.getMessage("search.transmission." + ad.getCar().getComplectation().getTransmission().getTransmissionName(), null, locale));
        dto.setFuelType(ad.getCar().getComplectation().getFuelType().getFuelTypeName());
        dto.setFuelTypeLocal(messageSource.getMessage("search.fuel_type." + ad.getCar().getComplectation().getFuelType().getFuelTypeName(), null, locale));
        dto.setColor(ad.getCar().getColor().getColorName());
        dto.setImage(ad.getCar().getImage());
        dto.setDescription(ad.getCar().getDescription());
        dto.setEnginevolume(ad.getCar().getComplectation().getEnginevolume());
        dto.setVin(ad.getCar().getVin());
        dto.setRrPrice(ad.getCar().getRrPrice());

        dto.setComplectationName(ad.getCar().getComplectation().getComplectationName());
        dto.setDrivetype(ad.getCar().getComplectation().getDrivetype().getDrivetypeName());
        dto.setDrivetypeLocal(messageSource.getMessage("search.drivetype." + ad.getCar().getComplectation().getDrivetype().getDrivetypeName().toLowerCase(), null, locale));
        dto.setHorsepower(ad.getCar().getComplectation().getHorsepower());
        dto.setAcceleration(ad.getCar().getComplectation().getAcceleration());
        dto.setCommonconsumption(ad.getCar().getComplectation().getCommonconsumption());
        dto.setCityconsumption(ad.getCar().getComplectation().getCityconsumption());
        dto.setRouteconsumption(ad.getCar().getComplectation().getRouteconsumption());
        dto.setLength(ad.getCar().getComplectation().getLength());
        dto.setWidth(ad.getCar().getComplectation().getWidth());
        dto.setMaxspeed(ad.getCar().getComplectation().getMaxspeed());
        dto.setComplectationId(ad.getCar().getComplectation().getComplectationId());
        dto.setHeadlight(ad.getCar().getComplectation().getHeadlight().getHeadlightName());
        dto.setHeadlightLocal(messageSource.getMessage("search.headlights." + ad.getCar().getComplectation().getHeadlight().getHeadlightName().toLowerCase(), null, locale));
        dto.setElectricheatingofthewindshield(ad.getCar().getComplectation().isElectricheatingofthewindshield());
        dto.setElectricheatingofsidemirrors(ad.getCar().getComplectation().isElectricheatingofsidemirrors());
        dto.setHeadlightwashersystem(ad.getCar().getComplectation().isHeadlightwashersystem());
        dto.setRainsensor(ad.getCar().getComplectation().isRainsensor());
        dto.setFoglight(ad.getCar().getComplectation().isFoglight());
        dto.setBluetooth(ad.getCar().getComplectation().isBluetooth());
        dto.setAux(ad.getCar().getComplectation().isAux());
        dto.setUsb(ad.getCar().getComplectation().isUsb());
        dto.setNavigationsystem(ad.getCar().getComplectation().isNavigationsystem());
        dto.setCruisecontrol(ad.getCar().getComplectation().isCruisecontrol());
        dto.setParktronic(ad.getCar().getComplectation().isParktronic());
        dto.setClimatecontrol(ad.getCar().getComplectation().isClimatecontrol());
        dto.setPowerWindows(ad.getCar().getComplectation().isPowerWindows());
        dto.setSteeringadjustment(ad.getCar().getComplectation().isSteeringadjustment());
        return dto;
    }

    private Ad toEntity(BaseCarDto dto) {

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

        Complectation complectation = complectationRepository.findById(dto.getComplectationId()).orElse(null);
        if (complectation == null) {
            complectation = new Complectation();
        }

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

        User user = userService.loadUserByUsername(securityHelper.getCurrentUser().getUsername());

        Ad ad = new Ad();
        ad.setAdId(dto.getAdId());
        ad.setCar(carRepository.save(car));
        ad.setUser(user);

        java.util.Date date = new java.util.Date();

        ad.setDateAdd(date);
        ad.setDateDelete(dto.getDateDelete());

        return ad;
    }
}
