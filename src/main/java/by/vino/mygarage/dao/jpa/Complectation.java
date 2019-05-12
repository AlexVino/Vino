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
@Table(name="complectations")
public class Complectation {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int complectationId;
    @Column
    private String complectationName;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "modelId")
    private Model model;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bodystyleId")
    private Bodystyle bodystyle;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fueltypeId")
    private FuelType fuelType;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "transmissionId")
    private Transmission transmission;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "drivetypeId")
    private Drivetype drivetype;
    @Column
    private int year;
    @Column
    private double enginevolume;
    @Column
    private int horsepower;
    @Column
    private double acceleration;
    @Column
    private double commonconsumption;
    @Column
    private double cityconsumption;
    @Column
    private double routeconsumption;
    @Column
    private int length;
    @Column
    private int width;
    @Column
    private int maxspeed;
    @Column
    private int complectationoptions;

    public int getComplectationId() {
        return complectationId;
    }

    public void setComplectationId(int complectationId) {
        this.complectationId = complectationId;
    }

    public String getComplectationName() {
        return complectationName;
    }

    public void setComplectationName(String complectationName) {
        this.complectationName = complectationName;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Bodystyle getBodystyle() {
        return bodystyle;
    }

    public void setBodystyle(Bodystyle bodystyle) {
        this.bodystyle = bodystyle;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public Drivetype getDrivetype() {
        return drivetype;
    }

    public void setDrivetype(Drivetype drivetype) {
        this.drivetype = drivetype;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getEnginevolume() {
        return enginevolume;
    }

    public void setEnginevolume(double enginevolume) {
        this.enginevolume = enginevolume;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(double acceleration) {
        this.acceleration = acceleration;
    }

    public double getCommonconsumption() {
        return commonconsumption;
    }

    public void setCommonconsumption(double commonconsumption) {
        this.commonconsumption = commonconsumption;
    }

    public double getCityconsumption() {
        return cityconsumption;
    }

    public void setCityconsumption(double cityconsumption) {
        this.cityconsumption = cityconsumption;
    }

    public double getRouteconsumption() {
        return routeconsumption;
    }

    public void setRouteconsumption(double routeconsumption) {
        this.routeconsumption = routeconsumption;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getMaxspeed() {
        return maxspeed;
    }

    public void setMaxspeed(int maxspeed) {
        this.maxspeed = maxspeed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Complectation)) return false;
        Complectation that = (Complectation) o;
        return complectationId == that.complectationId &&
                year == that.year &&
                Double.compare(that.enginevolume, enginevolume) == 0 &&
                horsepower == that.horsepower &&
                Double.compare(that.acceleration, acceleration) == 0 &&
                Double.compare(that.commonconsumption, commonconsumption) == 0 &&
                Double.compare(that.cityconsumption, cityconsumption) == 0 &&
                Double.compare(that.routeconsumption, routeconsumption) == 0 &&
                length == that.length &&
                width == that.width &&
                maxspeed == that.maxspeed &&
                complectationoptions == that.complectationoptions &&
                complectationName.equals(that.complectationName) &&
                model.equals(that.model) &&
                bodystyle.equals(that.bodystyle) &&
                fuelType.equals(that.fuelType) &&
                transmission.equals(that.transmission) &&
                drivetype.equals(that.drivetype);
    }

    @Override
    public int hashCode() {
        return Objects.hash(complectationId, complectationName, model, bodystyle, fuelType, transmission, drivetype, year, enginevolume, horsepower, acceleration, commonconsumption, cityconsumption, routeconsumption, length, width, maxspeed, complectationoptions);
    }
}