package by.bsuir.mpp.computershop.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "assembly_parcel")

public class AssemblyParcel {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @Column(name = "cost",nullable = false)
    private int cost;

    @Column(name = "count",nullable = false)
    private int count;

    @Column(name = "done_count",nullable = false, columnDefinition = "int default 0")
    private int doneCount;

    @Column(name = "canceled", nullable = false, columnDefinition = "bool default false")
    private boolean canceled;

    @OneToMany(mappedBy = "assembly_parcel", cascade = CascadeType.ALL)
    private List<AssemblerTask> assemblyParcels;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<AssemblerTask> assemblyOrders;

    public List<AssemblerTask> getAssemblyParcels(){return assemblyParcels;}
    public void setAssemblyParcels(List<AssemblerTask> assemblyParcels){this.assemblyParcels = assemblyParcels;}

    public List<AssemblerTask> getAssemblyOrders(){return assemblyOrders;}
    public void setAssemblyOrders(List<AssemblerTask> assemblyOrders){this.assemblyOrders = assemblyOrders;}

    public Order getOrder(){
        return this.order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }

    public int getCost(){
        return this.cost;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCount(){
        return this.count;
    }
    public void setCount(int count) {
        this.count = count;
    }

    public int getDoneCount(){
        return this.doneCount;
    }
    public void setDoneCount(int doneCount) {
        this.doneCount = doneCount;
    }

    public boolean getCanceled(){
        return this.canceled;
    }
    public void setCanceled(boolean canceled) {
        this.canceled = canceled;
    }
}
