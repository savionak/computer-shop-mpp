package by.bsuir.mpp.computershop.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "component_type")
public class ComponentType extends BaseEntity<Long> {

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    @Column(name = "removed", nullable = false)
    private Boolean removed;

    @OneToMany(mappedBy = "type", fetch = FetchType.LAZY)
    private List<ComponentModel> models;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean isRemoved() {
        return removed;
    }

    public void setRemoved(Boolean removed) {
        this.removed = removed;
    }

    public List<ComponentModel> getModels() {
        return models;
    }

    public void setModels(List<ComponentModel> componentModels) {
        this.models = componentModels;
    }
}
