package by.bsuir.mpp.computershop.entity;


import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
//@Embeddable
public class AssemblyComponentPK implements Serializable{

    private static final long serialVersionID = 1L;

    @ManyToOne
    @JoinColumn(name = "id")
    private ComponentStore component;

    @ManyToOne
    @JoinColumn(name = "id")
    private AssemblyParcel parcel;

    public ComponentStore getComponent() {
        return this.component;
    }
    public void setComponent(ComponentStore assemblyComponent) {
        this.component = assemblyComponent;
    }

    public AssemblyParcel getParcel() {
        return this.parcel;
    }
    public void setParcel(AssemblyParcel parcel) {
        this.parcel = parcel;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AssemblyComponentPK that = (AssemblyComponentPK) o;

        if (component != null ? !component.equals(that.component) : that.component != null) return false;
        if (parcel != null ? !parcel.equals(that.parcel) : that.parcel != null) return false;
        return true;
    }

    public int hashCode() {
        int result;
        result = (component != null ? component.hashCode() : 0);
        result = 31 * result + (parcel != null ? parcel.hashCode() : 0);
        return result;

    }

}
