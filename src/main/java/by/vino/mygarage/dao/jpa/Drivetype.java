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
@Table(name="drivetypes")
public class Drivetype {
    @Column
    @Id
    private int drivetypeId;
    @Column
    private String drivetypeName;

    public int getDrivetypeId() { return drivetypeId; }

    public void setDrivetypeId(int drivetypeId) { this.drivetypeId = drivetypeId; }

    public String getDrivetypeName() { return drivetypeName; }

    public void setDrivetypeName(String drivetypeName) { this.drivetypeName = drivetypeName; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Drivetype drivetype = (Drivetype) o;

        return drivetypeId == drivetype.drivetypeId &&
                Objects.equals(drivetypeName, drivetype.drivetypeName);
    }

    @Override
    public int hashCode() {
        int result = drivetypeId;
        result = 31 * result + (drivetypeName != null ? drivetypeName.hashCode() : 0);
        return result;
    }
}