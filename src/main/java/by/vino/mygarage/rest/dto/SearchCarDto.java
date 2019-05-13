package by.vino.mygarage.rest.dto;

public class SearchCarDto {
    private String model;
    private Integer minPrice;
    private Integer maxPrice;
    private String[] bodystyles;
    private Integer year;
    private Integer mileage;
    private String transmission;
    private String fuelType;
    private String color;
    private String complectationName;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Integer minPrice) {
        this.minPrice = minPrice;
    }

    public Integer getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Integer maxPrice) {
        this.maxPrice = maxPrice;
    }

    public String[] getBodystyles() {
        return bodystyles;
    }

    public void setBodystyles(String[] bodystyles) {
        this.bodystyles = bodystyles;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
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

    public String getComplectationName() {
        return complectationName;
    }

    public void setComplectationName(String complectationName) {
        this.complectationName = complectationName;
    }
}