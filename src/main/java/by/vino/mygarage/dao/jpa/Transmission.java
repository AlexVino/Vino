package by.vino.mygarage.dao.jpa;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="transmissions")
public class Transmission {
    @Column
    @Id
    private int transmissionId;
    @Column
    private String transmissionName;
}