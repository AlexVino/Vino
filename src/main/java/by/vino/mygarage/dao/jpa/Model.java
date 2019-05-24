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
@Table(name="models")
public class Model {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int modelId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "makeId")
    private Make make;

    @Column
    private String modelName;
}
