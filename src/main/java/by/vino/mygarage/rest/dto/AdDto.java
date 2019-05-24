package by.vino.mygarage.rest.dto;

import by.vino.mygarage.dao.jpa.Car;
import by.vino.mygarage.dao.jpa.User;
import lombok.Data;

@Data
public class AdDto {
    private int id;
    private User user;
    private Car car;
    private java.util.Date dateAdd;
    private java.util.Date dateDelete;
}
