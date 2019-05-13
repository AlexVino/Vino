package by.vino.mygarage.dao.jpa;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="fueltypes")
public class FuelType {
    @Column
    @Id
    private int fuelTypeId;
    @Column
    private String fuelTypeName;
}