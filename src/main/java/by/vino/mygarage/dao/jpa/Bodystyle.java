package by.vino.mygarage.dao.jpa;

import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@EqualsAndHashCode
@Entity
@Table(name="bodystyles")
public class Bodystyle {
    @Column
    @Id
    private int bodystyleId;
    @Column
    private String bodystyleName;

    public int getBodystyleId() {
        return bodystyleId;
    }

    public void setBodystyleId(int bodystyleId) {
        this.bodystyleId = bodystyleId;
    }

    public String getBodystyleName() {
        return bodystyleName;
    }

    public void setBodystyleName(String bodystyleName) {
        this.bodystyleName = bodystyleName;
    }
}