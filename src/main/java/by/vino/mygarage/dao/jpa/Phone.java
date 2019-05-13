package by.vino.mygarage.dao.jpa;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@Entity
@Table(name="phones")
public class Phone {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int phoneId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "addressId")
    private Address address;
    @Column
    private String phoneName;
}