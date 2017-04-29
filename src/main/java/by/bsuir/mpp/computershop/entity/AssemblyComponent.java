package by.bsuir.mpp.computershop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

import static by.bsuir.mpp.computershop.utils.ValidationConstants.CANNOT_BE_NEGATIVE_MESSAGE;
import static by.bsuir.mpp.computershop.utils.ValidationConstants.CANNOT_BE_NULL_MESSAGE;

@Entity
@Table(name = "assembly_component")
public class AssemblyComponent extends BaseEntity<Long> implements Serializable {
    @JsonIgnore
    @Id
    @ManyToOne
    @JoinColumn(name = "assembly_id", nullable = false)
    private Assembly assembly;

    @NotNull(message = CANNOT_BE_NULL_MESSAGE)
    @Id
    @ManyToOne
    @JoinColumn(name = "component_id", nullable = false)
    private ComponentStore component;

    @NotNull(message = CANNOT_BE_NULL_MESSAGE)
    @Min(value = 0, message = CANNOT_BE_NEGATIVE_MESSAGE)
    @Column(name = "count", nullable = false)
    private Long count;

    public Assembly getAssembly() {
        return assembly;
    }

    public void setAssembly(Assembly assemblyComponents) {
        this.assembly = assemblyComponents;
    }

    public ComponentStore getComponent() {
        return component;
    }

    public void setComponent(ComponentStore component) {
        this.component = component;
    }

    public Long getCount() {
        return this.count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
