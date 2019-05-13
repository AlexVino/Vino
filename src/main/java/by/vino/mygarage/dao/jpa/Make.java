package by.vino.mygarage.dao.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name="makes")
public class Make {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int makeId;
    @Column
    private String makeName;

    public int getMakeId() {
        return makeId;
    }

    public void setMakeId(int makeId) {
        this.makeId = makeId;
    }

    public String getMakeName() {
        return makeName;
    }

    public void setMakeName(String makeName) {
        this.makeName = makeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Make make = (Make) o;

        if (makeId != make.makeId) return false;
        return makeName != null ? makeName.equals(make.makeName) : make.makeName == null;
    }

    @Override
    public int hashCode() {
        int result = makeId;
        result = 31 * result + (makeName != null ? makeName.hashCode() : 0);
        return result;
    }
}
