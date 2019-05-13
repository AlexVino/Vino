package by.vino.mygarage.dao.jpa;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="colors")
public class Color {
    @Column
    @Id
    private int colorId;
    @Column
    private String colorName;
}