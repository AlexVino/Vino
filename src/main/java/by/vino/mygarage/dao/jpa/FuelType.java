package by.vino.mygarage.dao.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fueltypes")
public class FuelType {
    @Column
    @Id
    private int fuelTypeId;
    @Column
    private String fuelTypeName;

    public int getFuelTypeId() {
        return fuelTypeId;
    }

    public void setFuelTypeId(int fueltypeId) {
        this.fuelTypeId = fueltypeId;
    }

    public String getFuelTypeName() {
        return fuelTypeName;
    }

    public void setFuelTypeName(String fuelTypeName) {
        this.fuelTypeName = fuelTypeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FuelType fuelType = (FuelType) o;

        if (fuelTypeId != fuelType.fuelTypeId) return false;
        return fuelTypeName != null ? fuelTypeName.equals(fuelType.fuelTypeName) : fuelType.fuelTypeName == null;
    }

    @Override
    public int hashCode() {
        int result = fuelTypeId;
        result = 31 * result + (fuelTypeName != null ? fuelTypeName.hashCode() : 0);
        return result;
    }
}