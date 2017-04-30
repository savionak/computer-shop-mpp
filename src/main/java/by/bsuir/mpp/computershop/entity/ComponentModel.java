package by.bsuir.mpp.computershop.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "component_model")
public class ComponentModel extends BaseEntity<Long> {

    @ManyToOne
    @JoinColumn(name = "type_id", unique = true, nullable = false)
    private ComponentType type;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    @Column(name = "removed", nullable = false)
    private Boolean removed;

    @OneToMany(mappedBy = "model", fetch = FetchType.LAZY)
    private List<ComponentStore> storedComponents;

    @OneToMany(mappedBy = "model", fetch = FetchType.LAZY)
    private List<Import> imports;

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

    public Boolean isRemoved() {
        return removed;
    }

    public void setRemoved(Boolean removed) {
        this.removed = removed;
    }

    public List<ComponentStore> getStoredComponents() {
        return storedComponents;
    }

    public void setStoredComponents(List<ComponentStore> storedComponents) {
        this.storedComponents = storedComponents;
    }

    public List<Import> getImports() {
        return imports;
    }

    public void setImports(List<Import> imports) {
        this.imports = imports;
    }
}
