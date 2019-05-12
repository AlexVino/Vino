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
    @Column
    private String VIN;
    @Column
    private int rrPrice;
    @Column
    private int price;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "colorId")
    private Color color;
    @Column
    private int mileage;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "complectationId")
    private Complectation complectation;
    @Column
    private String description;
    @Column
    private String image;

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public int getRrPrice() {
        return rrPrice;
    }

    public void setRrPrice(int rrPrice) {
        this.rrPrice = rrPrice;
    }

    public Complectation getComplectation() {
        return complectation;
    }

    public void setComplectation(Complectation complectation) {
        this.complectation = complectation;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return carId == car.carId &&
                rrPrice == car.rrPrice &&
                price == car.price &&
                mileage == car.mileage &&
                VIN.equals(car.VIN) &&
                color.equals(car.color) &&
                complectation.equals(car.complectation) &&
                Objects.equals(description, car.description) &&
                Objects.equals(image, car.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carId, VIN, rrPrice, price, color, mileage, complectation, description, image);
    }
}
