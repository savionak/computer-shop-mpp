package by.bsuir.mpp.computershop.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "assembly_component")
public class AssemblyComponent extends BaseEntity<Long> implements Serializable {

    @ManyToOne
    @JoinColumn(name = "assembly_id", nullable = false)
    private Assembly assembly;

    @ManyToOne
    @JoinColumn(name = "component_id", nullable = false)
    private ComponentStore component;

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
