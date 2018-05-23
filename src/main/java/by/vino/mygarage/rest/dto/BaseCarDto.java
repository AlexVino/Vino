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
    @Max(value = 1000000000, message = "cars.mileage.size")
    private int mileage;
    private String transmission;
    private String transmissionLocal;
    private String fuelType;
    private String fuelTypeLocal;
    private String color;
    private String description;
    @NotNull(message = "cars.engine.null")
    @Min(value = 0, message = "cars.engine.size")
    @Max(value = 1000, message = "cars.engine.size")
    private double engine;
    private String image;

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

    public double getEngine() {
        return engine;
    }

    public void setEngine(double engine) {
        this.engine = engine;
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
}
