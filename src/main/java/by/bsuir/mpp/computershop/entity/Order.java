package by.bsuir.mpp.computershop.entity;

import javax.persistence.*;
import java.sql.Timestamp;
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
    private Timestamp ordDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status",nullable = false,
            columnDefinition = "ENUM ('GOING', 'READY','COMPLETED','CANCELLED')")
    private Status statusId;

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

    public Timestamp getOrdDate() {
        return ordDate;
    }
    public void setOrdDate(Timestamp ordDate) {
        this.ordDate = ordDate;
    }

    public int getCost(){
        return this.cost;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }

    public Status getOrderId(){
        return this.statusId;
    }
    public void setOrderId(Status statusId) {
        this.statusId =statusId;
    }

    public enum Status {
        GOING{
            public String toString() {
                return "собирается";
            }
        },
        READY{
            public String toString() {
                return "готов  сборке";
            }
        },
        COMPLETED{
            public String toString() {
                return "завершен";
            }
        },
        CANCELLED{
            public String toString() {
                return "отменен";
            }
        };
        public abstract String toString();

    }
}
