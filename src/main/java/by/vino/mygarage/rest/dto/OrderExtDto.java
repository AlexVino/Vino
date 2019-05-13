package by.vino.mygarage.rest.dto;

import lombok.Data;

@Data
public class OrderExtDto extends OrderDto{

    private String firstname;
    private String lastname;
    private String phone;
}