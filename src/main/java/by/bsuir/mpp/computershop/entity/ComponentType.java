package by.bsuir.mpp.computershop.entity;

import by.bsuir.mpp.computershop.dto.ComponentTypeDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

import static by.bsuir.mpp.computershop.config.ModelMapperConfiguration.mapper;
import static by.bsuir.mpp.computershop.utils.ValidationConstants.*;

@Entity
@Table(name = "component_type")
@DynamicInsert
public class ComponentType extends BaseEntity<Long> {
    @NotNull(message = CANNOT_BE_NULL_MESSAGE)
    @Pattern(regexp = NON_EMPTY_STRING_REGEX, message = CANNOT_BE_EMPTY_MESSAGE)
    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    @Column(name = "removed", nullable = false)
    private Boolean removed;

    @JsonIgnore
    @OneToMany(mappedBy = "type", fetch = FetchType.LAZY)
    private List<ComponentModel> componentModels;

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

    public List<ComponentModel> getComponentModels() {
        return componentModels;
    }

    public void setComponentModels(List<ComponentModel> componentModels) {
        this.componentModels = componentModels;
    }

    @Override
    public ComponentTypeDto toDto() {
        return mapper.map(this, ComponentTypeDto.class);
    }
}
