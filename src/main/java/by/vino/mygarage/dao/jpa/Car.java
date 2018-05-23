package by.vino.mygarage.dao.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Arrays;
import java.util.Objects;

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
    @Column
    private String description;
    @Column
    private String image;
    @Column
    private double engine;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return carId == car.carId &&
                price == car.price &&
                year == car.year &&
                mileage == car.mileage &&
                Double.compare(car.engine, engine) == 0 &&
                Objects.equals(model, car.model) &&
                Objects.equals(bodystyle, car.bodystyle) &&
                Objects.equals(transmission, car.transmission) &&
                Objects.equals(fuelType, car.fuelType) &&
                Objects.equals(color, car.color) &&
                Objects.equals(description, car.description) &&
                Objects.equals(image, car.image);
    }

    @Override
    public int hashCode() {

        return Objects.hash(carId, model, price, bodystyle, year, mileage, transmission, fuelType,
                color, description, engine, image);
    }
}
