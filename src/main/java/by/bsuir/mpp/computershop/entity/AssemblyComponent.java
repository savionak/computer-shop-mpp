package by.bsuir.mpp.computershop.entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "assembly_component")
@AssociationOverrides({
        @AssociationOverride(name = "assemblyOrder", joinColumns = @JoinColumn(name = "order_id")),
        @AssociationOverride(name = "assemblyComponent", joinColumns = @JoinColumn(name = "component_id")),
        @AssociationOverride(name = "assemblyId", joinColumns = @JoinColumn(name = "assembly_id"))})
public class AssemblyComponent implements Serializable{


    @EmbeddedId
    private AssemblyComponentPK Pk = new AssemblyComponentPK();

    @Id
    @ManyToOne
    @JoinColumn(name = "order_id",nullable = false)
    private AssemblyParcel assemblyOrder;

    @Id
    @ManyToOne
    @JoinColumn(name = "assembly_id",nullable = false)
    private AssemblyParcel assemblyId;

    @Id
    @ManyToOne
    @JoinColumn(name = "component_id",nullable = false)
    private ComponentStore assemblyComponent;

    @Column(name = "count",nullable = false)
    private int count;

    public AssemblyComponentPK getPk(){
        return this.Pk;
    }
    public void setPk(AssemblyComponentPK count) {
        this.Pk = Pk;
    }

    @Transient
    public AssemblyParcel getAssemblyOrder(){
        return getPk().getAssemblyOrder();
    }
    public void setAssemblyOrder(AssemblyParcel assemblyOrder) {
        getPk().setAssemblyOrder(assemblyOrder);
    }

    @Transient
    public AssemblyParcel getAssemblyId(){
        return getPk().getAssemblyId();
    }
    public void setAssemblyId(AssemblyParcel assemblyId) {
        getPk().setAssemblyId(assemblyId);
    }

    @Transient
    public ComponentStore getAssemblyComponent(){
        return getPk().getAssemblyComponent();
    }
    public void setAssemblyComponent(ComponentStore assemblyComponent) {
        getPk().setAssemblyComponent(assemblyComponent);
    }

    public int getCount(){
        return this.count;
    }
    public void setCount(int count) {
        this.count = count;
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        OrderComponent that = (OrderComponent) o;

        if (getPk() != null ? !getPk().equals(that.getPk())
                : that.getPk() != null)
            return false;

        return true;
    }

    public int hashCode() {
        return (getPk() != null ? getPk().hashCode() : 0);
    }



}
