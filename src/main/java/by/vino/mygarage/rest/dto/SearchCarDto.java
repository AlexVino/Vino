package by.vino.mygarage.rest.dto;

import lombok.Data;

@Data
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
}