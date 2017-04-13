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
    private AssemblyParcel assemblyComponents;

    @Id
    @ManyToOne
    @JoinColumn(name = "component_id", nullable = false)
    private ComponentStore assemblyComponent;

    @Column(name = "count", nullable = false)
    private long count;

    public AssemblyParcel getAssemblyComponents() {
        return assemblyComponents;
    }

    public void setAssemblyComponents(AssemblyParcel assemblyComponents) {
        this.assemblyComponents = assemblyComponents;
    }

    public ComponentStore getAssemblyComponent() {
        return assemblyComponent;
    }

    public void setAssemblyComponent(ComponentStore assemblyOrder) {
        this.assemblyComponent = assemblyComponent;
    }

    public long getCount() {
        return this.count;
    }

    public void setCount(long count) {
        this.count = count;
    }

}
