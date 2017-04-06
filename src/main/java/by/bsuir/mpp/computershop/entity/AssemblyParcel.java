package by.bsuir.mpp.computershop.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "assembly_parcel")

public class AssemblyParcel {

    @Column(nullable = false)
    private int order_id;

    @Column(nullable = false)
    private int cost;

    @Column(nullable = false)
    private int count;

    @Column(nullable = false)
    private int done_count;

    @Column(nullable = false)
    private boolean canceled;

    public int getOrder_id(){
        return this.order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
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

    public int getDone_count(){
        return this.done_count;
    }

    public void setDone_count(int done_count) {
        this.done_count = done_count;
    }

    public boolean getCanceled(){
        return this.canceled;
    }

    public void setCanceled(boolean canceled) {
        this.canceled = canceled;
    }
}
