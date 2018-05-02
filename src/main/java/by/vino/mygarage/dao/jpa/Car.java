package by.vino.mygarage.dao.jpa;

import com.querydsl.core.annotations.PropertyType;
import com.querydsl.core.annotations.QueryType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="cars")
public class Car {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int carId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "modelId")
    private Model model;
    @Column
    private int price;
    @Transient
    private int minPrice;
    @QueryType(value = PropertyType.STRING)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bodystyleId")
    private Bodystyle bodystyle;
    @Column
    private int year;
    @Column
    private int mileage;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "transmissionId")
    private Transmission transmission;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fuelTypeId")
    private FuelType fuelType;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "colorId")
    private Color color;

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Bodystyle getBodystyle() {
        return bodystyle;
    }

    public void setBodystyle(Bodystyle bodystyle) {
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

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (carId != car.carId) return false;
        if (price != car.price) return false;
        if (year != car.year) return false;
        if (mileage != car.mileage) return false;
        if (model != null ? !model.equals(car.model) : car.model != null) return false;
        if (bodystyle != null ? !bodystyle.equals(car.bodystyle) : car.bodystyle != null) return false;
        if (transmission != null ? !transmission.equals(car.transmission) : car.transmission != null) return false;
        if (fuelType != null ? !fuelType.equals(car.fuelType) : car.fuelType != null) return false;
        return color != null ? color.equals(car.color) : car.color == null;
    }

    @Override
    public int hashCode() {
        int result = carId;
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + price;
        result = 31 * result + (bodystyle != null ? bodystyle.hashCode() : 0);
        result = 31 * result + year;
        result = 31 * result + mileage;
        result = 31 * result + (transmission != null ? transmission.hashCode() : 0);
        result = 31 * result + (fuelType != null ? fuelType.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        return result;
    }
}
