package by.bsuir.mpp.computershop.entity;

import javax.persistence.*;

@Entity
@Table(name = "component_model")
public class ComponentModel extends BaseSoftEntity<Long> {

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private ComponentType type;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    public ComponentType getType() {
        return this.type;
    }

    public void setType(ComponentType type) {
        this.type = type;
    }

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
}
