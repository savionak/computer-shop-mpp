package by.bsuir.mpp.computershop.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "assembly_component")
public class AssemblyComponent implements Serializable {

    @Id
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "assembly_id", referencedColumnName = "id", nullable = false),
            @JoinColumn(name = "order_id", referencedColumnName = "order_id", nullable = false)}
    )
    private AssemblyParcel parcel;

    @Id
    @ManyToOne
    @JoinColumn(name = "component_id", nullable = false)
    private ComponentStore component;

    @Column(name = "count", nullable = false)
    private long count;

    public AssemblyParcel getParcel() {
        return parcel;
    }

    public void setParcel(AssemblyParcel assemblyComponents) {
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
