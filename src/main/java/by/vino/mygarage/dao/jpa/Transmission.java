package by.vino.mygarage.dao.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transmissions")
public class Transmission {
    @Column
    @Id
    private int transmissionId;
    @Column
    private String transmissionName;

    public int getTransmissionId() {
        return transmissionId;
    }

    public void setTransmissionId(int transmissionId) {
        this.transmissionId = transmissionId;
    }

    public String getTransmissionName() {
        return transmissionName;
    }

    public void setTransmissionName(String transmissionName) {
        this.transmissionName = transmissionName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transmission transmission = (Transmission) o;

        if (transmissionId != transmission.transmissionId) return false;
        return transmissionName != null ? transmissionName.equals(transmission.transmissionName) : transmission.transmissionName == null;
    }

    @Override
    public int hashCode() {
        int result = transmissionId;
        result = 31 * result + (transmissionName != null ? transmissionName.hashCode() : 0);
        return result;
    }
}