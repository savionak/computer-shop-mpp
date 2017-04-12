package by.bsuir.mpp.computershop.entity;


import javax.persistence.*;

//@Entity
@Table(name = "assembly_component")
public class AssemblyComponent extends BaseEntity<Long>{

    @ManyToOne
    @JoinColumn(name = "component_id")
    private ComponentStore componentId;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "order_id"),
            @JoinColumn(name = "assembly_id")}
    )
    private AssemblyParcel parcel;

    @Column(name = "count",nullable = false)
    private long count;

    public long getCount(){
        return this.count;
    }
    public void setCount(long count) {
        this.count = count;
    }

    public ComponentStore getComponentId() {
        return componentId;
    }

    public void setComponentId(ComponentStore componentId) {
        this.componentId = componentId;
    }

    public AssemblyParcel getParcel() {
        return parcel;
    }

    public void setParcel(AssemblyParcel parcelId) {
        this.parcel = parcelId;
    }
}
