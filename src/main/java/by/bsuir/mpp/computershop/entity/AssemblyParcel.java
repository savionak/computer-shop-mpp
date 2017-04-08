package by.bsuir.mpp.computershop.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "assembly_parcel")

public class AssemblyParcel {

    @Column(name = "order_id",nullable = false)
    private int orderId;

    @Column(name = "cost",nullable = false)
    private int cost;

    @Column(name = "count",nullable = false)
    private int count;

    @Column(name = "done_count",nullable = false)
    private int doneCount;

    @Column(name = "canceled", nullable = false)
    private boolean canceled;

    public int getOrderId(){
        return this.orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
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
