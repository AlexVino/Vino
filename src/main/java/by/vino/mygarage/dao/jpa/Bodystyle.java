package by.vino.mygarage.dao.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bodystyle bodystyle = (Bodystyle) o;

        return bodystyleId == bodystyle.bodystyleId &&
                Objects.equals(bodystyleName, bodystyle.bodystyleName);
    }

    @Override
    public int hashCode() {
        int result = bodystyleId;
        result = 31 * result + (bodystyleName != null ? bodystyleName.hashCode() : 0);
        return result;
    }
}