package by.vino.mygarage.dao.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;

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

    public int getOptionId() {
        return optionId;
    }

    public void setOptionId(int optionId) {
        this.optionId = optionId;
    }

    public Optioncategory getOptioncategory() {
        return optioncategory;
    }

    public void setOptioncategory(Optioncategory optioncategory) {
        this.optioncategory = optioncategory;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Option option = (Option) o;

        if (optionId != option.optionId) return false;
        if (optioncategory != null ? !optioncategory.equals(option.optioncategory) : option.optioncategory != null) return false;
        return optionName != null ? optionName.equals(option.optionName) : option.optionName == null;
    }

    @Override
    public int hashCode() {
        int result = optionId;
        result = 31 * result + (optioncategory != null ? optioncategory.hashCode() : 0);
        result = 31 * result + (optionName != null ? optionName.hashCode() : 0);
        return result;
    }
}