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
    private boolean Electricheatingofthewindshield;

    @Column
    private boolean Electricheatingofsidemirrors;

    @Column
    private boolean Headlightwashersystem;

    @Column
    private boolean Rainsensor;

    @Column
    private boolean Foglight;

    @Column
    private boolean Bluetooth;

    @Column
    private boolean USB;

    @Column
    private boolean AUX;

    @Column
    private boolean Navigationsystem;

    @Column
    private boolean Cruisecontrol;

    @Column
    private boolean Parktronic;

    @Column
    private boolean Climatecontrol;

    @Column
    private boolean PowerWindows;

    @Column
    private boolean steeringadjustment;
}