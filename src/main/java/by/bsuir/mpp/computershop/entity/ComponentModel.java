package by.bsuir.mpp.computershop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "component_model")
public class ComponentModel extends BaseEntity<Long> {

    @NotNull(message = "Name cannot be null")
    @Pattern(regexp = "^(?!\\s*$).+", message = "Model name cannot be empty")
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull(message = "Description cannot be null")
    @Column(name = "description", columnDefinition = "text")
    private String description;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id", unique = true, nullable = false)
    private ComponentType type;

    @Transient
    private Long newTypeId;

    @JsonProperty(value = "typeId")
    public Long getTypeId() {
        return type.getId();
    }

    @JsonProperty(value = "typeId")
    public void setTypeId(Long id) {
        newTypeId = id;
    }

    @JsonProperty(value = "type")
    private String getTypeName() {
        return type.getName();
    }

    @JsonIgnore
    public Long getNewTypeId() {
        return newTypeId;
    }

//    @OneToMany(mappedBy = "model", cascade = CascadeType.ALL)
//    private List<ComponentStore> storedComponent;
//
//    @OneToMany(mappedBy = "model", cascade = CascadeType.ALL)
//    private List<Import> imports;
//
//    public List<Import> getImports() {
//        return imports;
//    }
//
//    public void setImports(List<Import> imports) {
//        this.imports = imports;
//    }

//    public List<ComponentStore> getStoredComponent() {
//        return storedComponent;
//    }
//
//    public void setStoredComponent(List<ComponentStore> storedComponent) {
//        this.storedComponent = storedComponent;
//    }

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
