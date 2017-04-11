package by.bsuir.mpp.computershop.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;


@Entity
@Table(name = "order")
public class Order extends BaseEntity<Long> {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Column(name = "cost",nullable = false)
    private int cost;

    @Column(name = "ord_date",nullable = false)
    private Date ordDate;

    @Column(name = "status_id",nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private OrderStatus statusId;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order", cascade = CascadeType.ALL)
    private List<Export> exports;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order", cascade = CascadeType.ALL)
    private List<AssemblyParcel> assemblyParcels;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orderOrder", cascade = CascadeType.ALL)
    private List<OrderComponent> orderComponents;

    public List<OrderComponent> getOrderComponents(){return orderComponents;}
    public void setOrderComponents(List<OrderComponent> orderComponents){this.orderComponents = orderComponents;}

    public List<AssemblyParcel> getAssemblyParcels(){return assemblyParcels;}
    public void setAssemblyParcels(List<AssemblyParcel> assemblyParcels){this.assemblyParcels = assemblyParcels;}

    public List<Export> getExports(){return exports;}
    public void setExports(List<Export> exports){this.exports = exports;}

    public Customer getCustomer(){
        return this.customer;
    }
    public void setCustomer(Customer customerId) {
        this.customer = customer;
    }

    public Date getOrdDate() {
        return ordDate;
    }
    public void setOrdDate(Date ordDate) {
        this.ordDate = ordDate;
    }

    public int getCost(){
        return this.cost;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }

    public OrderStatus getOrderId(){
        return this.statusId;
    }
    public void setOrderId(OrderStatus statusId) {
        this.statusId =statusId;
    }
}
