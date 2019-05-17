package by.vino.mygarage.dao.jpa;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="headlights")
public class Headlights {
    @Column
    @Id
    private int headlightId;
    @Column
    private String headlightName;
}