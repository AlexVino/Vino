package by.vino.mygarage.rest.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

    @NotEmpty(message = "cars.VIN.empty")
    @Size(min = 17, max = 17, message = "cars.VIN.size")
    private String VIN;

    @Min(value = 0, message = "cars.rrPrice.size")
    @Max(value = 1_000_000_000, message = "cars.rrPrice.size")
    private int rrPrice;

    @NotEmpty(message = "cars.complectationName.empty")
    @Size(min = 1, max = 30, message = "cars.complectationName.size")
    private String complectationName;

    private String drivetype;
    private String drivetypeLocal;

    @NotNull(message = "cars.horsepower.null")
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


    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBodystyle() {
        return bodystyle;
    }

    public void setBodystyle(String bodystyle) {
        this.bodystyle = bodystyle;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFullModel() {
        return fullModel;
    }

    public void setFullModel(String fullModel) {
        this.fullModel = fullModel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBodystyleLocal() {
        return bodystyleLocal;
    }

    public void setBodystyleLocal(String bodystyleLocal) {
        this.bodystyleLocal = bodystyleLocal;
    }

    public String getTransmissionLocal() {
        return transmissionLocal;
    }

    public void setTransmissionLocal(String transmissionLocal) {
        this.transmissionLocal = transmissionLocal;
    }

    public String getFuelTypeLocal() {
        return fuelTypeLocal;
    }

    public void setFuelTypeLocal(String fuelTypeLocal) {
        this.fuelTypeLocal = fuelTypeLocal;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public double getEnginevolume() {
        return enginevolume;
    }

    public void setEnginevolume(double enginevolume) {
        this.enginevolume = enginevolume;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public int getRrPrice() {
        return rrPrice;
    }

    public void setRrPrice(int rrPrice) {
        this.rrPrice = rrPrice;
    }

    public String getComplectationName() {
        return complectationName;
    }

    public void setComplectationName(String complectationName) {
        this.complectationName = complectationName;
    }

    public String getDrivetype() {
        return drivetype;
    }

    public void setDrivetype(String drivetype) {
        this.drivetype = drivetype;
    }

    public String getDrivetypeLocal() {
        return drivetypeLocal;
    }

    public void setDrivetypeLocal(String drivetypeLocal) {
        this.drivetypeLocal = drivetypeLocal;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(double acceleration) {
        this.acceleration = acceleration;
    }

    public double getCommonconsumption() {
        return commonconsumption;
    }

    public void setCommonconsumption(double commonconsumption) {
        this.commonconsumption = commonconsumption;
    }

    public double getCityconsumption() {
        return cityconsumption;
    }

    public void setCityconsumption(double cityconsumption) {
        this.cityconsumption = cityconsumption;
    }

    public double getRouteconsumption() {
        return routeconsumption;
    }

    public void setRouteconsumption(double routeconsumption) {
        this.routeconsumption = routeconsumption;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getMaxspeed() {
        return maxspeed;
    }

    public void setMaxspeed(int maxspeed) {
        this.maxspeed = maxspeed;
    }

    public int getComplectationId() {
        return complectationId;
    }

    public void setComplectationId(int complectationId) {
        this.complectationId = complectationId;
    }
}