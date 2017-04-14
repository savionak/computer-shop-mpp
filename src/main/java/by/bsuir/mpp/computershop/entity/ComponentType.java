package by.bsuir.mpp.computershop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@Table(name = "component_type")
public class ComponentType extends BaseEntity<Long> {

    @NotNull(message = "Name cannot be null")
    @Pattern(regexp = "^(?!\\s*$).+", message = "Component type name cannot be empty")
    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "type", fetch = FetchType.LAZY)
    private List<ComponentModel> componentModels;

    public List<ComponentModel> getComponentModels() {
        return componentModels;
    }

    public void setComponentModels(List<ComponentModel> componentModels) {
        this.componentModels = componentModels;
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
