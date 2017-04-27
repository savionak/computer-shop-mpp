package by.bsuir.mpp.computershop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "assembly_component")
public class AssemblyComponent implements Serializable {

    @JsonIgnore
    @Id
    @ManyToOne
    @JoinColumn(name = "assembly_id", nullable = false)
    private Assembly parcel;

    @Id
    @ManyToOne
    @JoinColumn(name = "component_id", nullable = false)
    private ComponentStore component;

    @NotNull(message = "Cannot be null")
    @Min(value = 0, message = "Count cannot be negative")
    @Column(name = "count", nullable = false)
    private long count;

    public Assembly getParcel() {
        return parcel;
    }

    public void setParcel(Assembly assemblyComponents) {
        this.parcel = assemblyComponents;
    }

    public ComponentStore getComponent() {
        return component;
    }

    public void setComponent(ComponentStore component) {
        this.component = component;
    }

    public long getCount() {
        return this.count;
    }

    public void setCount(long count) {
        this.count = count;
    }

}
