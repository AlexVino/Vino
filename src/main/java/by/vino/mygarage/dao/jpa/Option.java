package by.vino.mygarage.dao.jpa;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;

@Data
@Entity
@Table(name="options")
public class Option {
    @Column
    @Id
    private int optionId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "optioncategoryId")
    private Optioncategory optioncategory;
    @Column
    private String optionName;
}