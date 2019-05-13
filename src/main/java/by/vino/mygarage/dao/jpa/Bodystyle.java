package by.vino.mygarage.dao.jpa;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Data
@Entity
@Table(name="bodystyles")
public class Bodystyle {
    @Column
    @Id
    private int bodystyleId;
    @Column
    private String bodystyleName;
}