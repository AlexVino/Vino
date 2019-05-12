package by.vino.mygarage.dao.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name="optioncategories")
public class Optioncategory {
    @Column
    @Id
    private int optioncategoryId;
    @Column
    private String optioncategoryName;

    public int getOptioncategoryId() {
        return optioncategoryId;
    }

    public void setOptioncategoryId(int optioncategoryId) {
        this.optioncategoryId = optioncategoryId;
    }

    public String getOptioncategoryName() {
        return optioncategoryName;
    }

    public void setOptioncategoryName(String optioncategoryName) {
        this.optioncategoryName = optioncategoryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Optioncategory optioncategory = (Optioncategory) o;

        return optioncategoryId == optioncategory.optioncategoryId &&
                Objects.equals(optioncategoryName, optioncategory.optioncategoryName);
    }

    @Override
    public int hashCode() {
        int result = optioncategoryId;
        result = 31 * result + (optioncategoryName != null ? optioncategoryName.hashCode() : 0);
        return result;
    }
}