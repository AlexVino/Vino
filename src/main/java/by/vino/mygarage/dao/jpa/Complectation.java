package by.vino.mygarage.dao.jpa;

import lombok.Data;

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

@Data
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "headlightId")
    private Headlights headlight;

    @Column
    private boolean electricheatingofthewindshield;

    @Column
    private boolean electricheatingofsidemirrors;

    @Column
    private boolean headlightwashersystem;

    @Column
    private boolean rainsensor;

    @Column
    private boolean foglight;

    @Column
    private boolean bluetooth;

    @Column
    private boolean usb;

    @Column
    private boolean aux;

    @Column
    private boolean navigationsystem;

    @Column
    private boolean cruisecontrol;

    @Column
    private boolean parktronic;

    @Column
    private boolean climatecontrol;

    @Column
    private boolean powerWindows;

    @Column
    private boolean steeringadjustment;
}