package by.vino.mygarage.rest.dto;

import lombok.Data;

@Data
public class OrderDto {
    private int id;
    private String fullModel;
    private int price;
}