package by.vino.mygarage.rest.dto;

public class BaseCarDto {
    private int carId;
    private String fullModel;
    private String model;
    private int price;
    private String bodystyle;
    private String bodystyleLocal;
    private int year;
    private int mileage;
    private String transmission;
    private String transmissionLocal;
    private String fuelType;
    private String fuelTypeLocal;
    private String color;
    private String description;
    private double engine;
    private byte[] image;

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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
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
}
