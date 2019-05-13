package by.vino.mygarage.dao.jpa;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@Entity
@Table(name="makes")
public class Make {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int makeId;
    @Column
    private String makeName;
}
