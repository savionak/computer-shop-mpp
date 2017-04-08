package by.bsuir.mpp.computershop.entity;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "import")
public class Order extends BaseEntity<Long> {

    @Column(name = "customer_id",nullable = false)
    private int customerId;

    @Column(name = "cost",nullable = false)
    private int cost;

    @Column(name = "ord_date",nullable = false)
    private Date ordDate;

    @Column(name = "status_id",nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private OrderStatus statusId;

    public int getCustomerId(){
        return this.customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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
