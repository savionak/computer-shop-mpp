package by.bsuir.mpp.computershop.entity;

import by.bsuir.mpp.computershop.dto.ComponentModelDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

import static by.bsuir.mpp.computershop.config.ModelMapperConfiguration.modelMapper;
import static by.bsuir.mpp.computershop.utils.ValidationConstants.*;

@Entity
@Table(name = "component_model")
@DynamicInsert
public class ComponentModel extends BaseEntity<Long> {
    @NotNull(message = CANNOT_BE_NULL_MESSAGE)
    @ManyToOne
    @JoinColumn(name = "type_id", unique = true, nullable = false)
    private ComponentType type;

    @NotNull(message = CANNOT_BE_NULL_MESSAGE)
    @Pattern(regexp = NON_EMPTY_STRING_REGEX, message = CANNOT_BE_EMPTY_MESSAGE)
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    @Column(name = "removed", nullable = false)
    private Boolean removed;

    @JsonIgnore
    @OneToMany(mappedBy = "model")
    private List<ComponentStore> storedComponents;

    @JsonIgnore
    @OneToMany(mappedBy = "model")
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

    @Override
    public ComponentModelDto toDto() {
        return modelMapper.map(this, ComponentModelDto.class);
    }
}
