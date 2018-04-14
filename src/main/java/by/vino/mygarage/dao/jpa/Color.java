package by.vino.mygarage.dao.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="colors")
public class Color {
    @Column
    @Id
    private int colorId;
    @Column
    private String colorName;

    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Color color = (Color) o;

        if (colorId != color.colorId) return false;
        return colorName != null ? colorName.equals(color.colorName) : color.colorName == null;
    }

    @Override
    public int hashCode() {
        int result = colorId;
        result = 31 * result + (colorName != null ? colorName.hashCode() : 0);
        return result;
    }
}