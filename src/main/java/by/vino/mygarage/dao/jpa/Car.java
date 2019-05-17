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
@Table(name="cars")
public class Car {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int carId;

    @Column
    private String VINnumber;

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
}
