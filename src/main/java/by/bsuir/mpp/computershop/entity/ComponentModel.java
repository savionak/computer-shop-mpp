package by.bsuir.mpp.computershop.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "component_model")
public class ComponentModel extends BaseEntity<Long>{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id",unique = true, nullable = false)
    private ComponentType type;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "description",columnDefinition = "text")
    private String description;

    @OneToMany(mappedBy = "model", cascade = CascadeType.ALL)
    private List<Import> imports;

    @OneToMany(mappedBy = "model", cascade = CascadeType.ALL)
    private List<ComponentStore> storedComponent;

    @OneToMany(mappedBy = "component", cascade = CascadeType.ALL)
    private List<InventoryItem> inventoryItems;

    public List<InventoryItem> getInventoryItems(){return inventoryItems;}
    public void setInventoryItems(List<InventoryItem> storedComponent){this.inventoryItems = inventoryItems;}

    public List<Import> getImports(){return imports;}
    public void setImports(List<Import> imports){this.imports = imports;}

    public List<ComponentStore> getStoredComponent(){return storedComponent;}
    public void setStoredComponent(List<ComponentStore> storedComponent){this.storedComponent = storedComponent;}

    public ComponentType getType(){
        return this.type;
    }
    public void setType(ComponentType type) {
        this.type = type;
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
