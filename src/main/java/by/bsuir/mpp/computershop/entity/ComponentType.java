package by.bsuir.mpp.computershop.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "component_type")
public class ComponentType extends BaseEntity<Long> {

    @Column(name = "name",unique = true, nullable = false)
    private String name;

    @Column(name = "description",columnDefinition = "text")
    private String description;

    @OneToMany(mappedBy = "typeId", cascade = CascadeType.ALL)
    private List<ComponentModel> componentModels;

    public List<ComponentModel> getComponentModels(){return componentModels;}

    public void setComponentModels(List<ComponentModel> componentModels){this.componentModels = componentModels;}

    public String getName(){
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
