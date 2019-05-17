package by.vino.mygarage.rest.dto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class BaseCarDto {
    private int carId;
    private String fullModel;
    private String make;

    @NotEmpty(message = "cars.model.empty")
    @Size(min = 1, max = 30, message = "cars.model.size")
    private String model;

    @NotNull(message = "cars.price.null")
    @Min(value = 0, message = "cars.price.size")
    @Max(value = 1_000_000_000, message = "cars.price.size")
    private int price;

    @NotEmpty(message = "cars.bodystyle.empty")
    @Size(min = 1, max = 30, message = "cars.bodystyle.size")
    private String bodystyle;
    private String bodystyleLocal;

    @NotNull(message = "cars.year.null")
    @Min(value = 1800, message = "cars.year.min")
    @Max(value = 2100, message = "cars.year.max")
    private int year;

    @NotNull(message = "cars.mileage.null")
    @Min(value = 0, message = "cars.mileage.size")
    @Max(value = 1_000_000_000, message = "cars.mileage.size")
    private int mileage;

    private String transmission;
    private String transmissionLocal;
    private String fuelType;
    private String fuelTypeLocal;
    private String color;
    private String description;

    @NotNull(message = "cars.enginevolume.null")
    @Min(value = 0, message = "cars.enginevolume.size")
    @Max(value = 1000, message = "cars.enginevolume.size")
    private double enginevolume;

    private String image;

    private int complectationId;

    //@NotEmpty(message = "cars.VINnumber.empty")
    @Size(min = 17, max = 17, message = "cars.VINnumber.size")
    private String VINnumber;

    @Min(value = 0, message = "cars.rrPrice.size")
    @Max(value = 1_000_000_000, message = "cars.rrPrice.size")
    private int rrPrice;

    //NotEmpty(message = "cars.complectationName.empty")
    @Size(min = 1, max = 30, message = "cars.complectationName.size")
    private String complectationName;

    private String drivetype;
    private String drivetypeLocal;

    //@NotNull(message = "cars.horsepower.null")
    @Min(value = 0, message = "cars.horsepower.size")
    @Max(value = 100_000, message = "cars.horsepower.size")
    private int horsepower;

    @Min(value = 0, message = "cars.acceleration.size")
    @Max(value = 1000, message = "cars.acceleration.size")
    private double acceleration;

    @Min(value = 0, message = "cars.commonconsumption.size")
    @Max(value = 1000, message = "cars.commonconsumption.size")
    private double commonconsumption;

    @Min(value = 0, message = "cars.cityconsumption.size")
    @Max(value = 1000, message = "cars.cityconsumption.size")
    private double cityconsumption;

    @Min(value = 0, message = "cars.routeconsumption.size")
    @Max(value = 1000, message = "cars.routeconsumption.size")
    private double routeconsumption;

    @Min(value = 0, message = "cars.length.size")
    @Max(value = 100_000, message = "cars.length.size")
    private int length;

    @Min(value = 0, message = "cars.width.size")
    @Max(value = 100_000, message = "cars.width.size")
    private int width;

    @Min(value = 0, message = "cars.maxspeed.size")
    @Max(value = 100_000, message = "cars.maxspeed.size")
    private int maxspeed;

    private String headlight;
    private String headlightLocal;

    private boolean Electricheatingofthewindshield;
    private boolean Electricheatingofsidemirrors;
    private boolean Headlightwashersystem;
    private boolean Rainsensor;
    private boolean Foglight;
    private boolean Bluetooth;
    private boolean USB;
    private boolean AUX;
    private boolean Navigationsystem;
    private boolean Cruisecontrol;
    private boolean Parktronic;
    private boolean Climatecontrol;
    private boolean PowerWindows;
    private boolean steeringadjustment;
}