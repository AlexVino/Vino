package by.vino.mygarage.dao.jpa;

import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode
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
}
