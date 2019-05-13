package by.vino.mygarage.dao.jpa;

import lombok.Data;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

@Data
@Entity
@Table(name="ads")
public class Ad {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int adId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    private User user;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "carId")
    private Car car;
    @Column(name="dateAdd")
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date dateAdd;
    @Column(name="dateDelete")
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date dateDelete;
}