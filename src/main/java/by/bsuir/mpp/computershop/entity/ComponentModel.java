package by.bsuir.mpp.computershop.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "component_model")
public class ComponentModel extends BaseEntity<Long>{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id",unique = true, nullable = false)
    private ComponentType typeId;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "description",columnDefinition = "text")
    private String description;

    @OneToMany(mappedBy = "modelId", cascade = CascadeType.ALL)
    private List<Import> imports;
    private List<ComponentStore> componentStores;

    public List<Import> getImports(){return imports;}
    public void setImports(List<Import> imports){this.imports = imports;}

    public List<ComponentStore> getComponentStores(){return componentStores;}
    public void setComponentStores(List<ComponentStore> componentStores){this.componentStores = componentStores;}

    public ComponentType getTypeId(){
        return this.typeId;
    }
    public void setTypeId(ComponentType typeId) {
        this.typeId = typeId;
    }

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
