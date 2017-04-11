package by.bsuir.mpp.computershop.entity;


import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;
@Embeddable
public class AssemblyComponentPK implements Serializable{

    private static final long serialVersionID = 1L;

    @ManyToOne
    private ComponentStore assemblyComponent;

    @ManyToOne
    private AssemblyParcel assemblyOrder;

    @ManyToOne
    private AssemblyParcel assemblyId;

    public ComponentStore getAssemblyComponent() {
        return this.assemblyComponent;
    }
    public void setAssemblyComponent(ComponentStore assemblyComponent) {
        this.assemblyComponent = assemblyComponent;
    }

    public AssemblyParcel getAssemblyOrder() {
        return this.assemblyOrder;
    }
    public void setAssemblyOrder(AssemblyParcel orderComponent) {
        this.assemblyOrder = assemblyOrder;
    }

    public AssemblyParcel getAssemblyId() {
        return this.assemblyId;
    }
    public void setAssemblyId(AssemblyParcel assemblyId) {
        this.assemblyId = assemblyId;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AssemblyComponentPK that = (AssemblyComponentPK) o;

        if (assemblyComponent != null ? !assemblyComponent.equals(that.assemblyComponent) : that.assemblyComponent != null) return false;
        if (assemblyId != null ? !assemblyId.equals(that.assemblyId) : that.assemblyId != null) return false;
        if (assemblyOrder != null ? !assemblyOrder.equals(that.assemblyOrder) : that.assemblyOrder != null)
            return false;

        return true;
    }

    public int hashCode() {
        int result;
        result = (assemblyComponent != null ? assemblyComponent.hashCode() : 0);
        result = (assemblyOrder != null ? assemblyOrder.hashCode() : 0);
        result = 31 * result + (assemblyId != null ? assemblyId.hashCode() : 0);
        return result;

    }

}
