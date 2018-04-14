package by.vino.mygarage.dao.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="models")
public class Model {
    @Column
    @Id
    private int modelId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "makeId")
    private Make make;
    @Column
    private String modelName;

    public int getModelId() {
        return modelId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    public Make getMake() {
        return make;
    }

    public void setMake(Make make) {
        this.make = make;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Model model = (Model) o;

        if (modelId != model.modelId) return false;
        if (make != null ? !make.equals(model.make) : model.make != null) return false;
        return modelName != null ? modelName.equals(model.modelName) : model.modelName == null;
    }

    @Override
    public int hashCode() {
        int result = modelId;
        result = 31 * result + (make != null ? make.hashCode() : 0);
        result = 31 * result + (modelName != null ? modelName.hashCode() : 0);
        return result;
    }
}
