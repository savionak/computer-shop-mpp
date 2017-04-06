package by.bsuir.mpp.computershop.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "order")
public class Order extends BaseEntity<Long> {

    @Column(nullable = false)
    private int provider_id;

    @Column(nullable = false)
    private Date date_time;

    @Column(nullable = false)
    private int count;

    @Column(nullable = false)
    private int model_id;

    @Column(nullable = false)
    private int purchase_price;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private int status_id;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private OrderStatus orderStatus;

    public int getProvider_id(){
        return this.provider_id;
    }

    public void setProvider_id(int name) {
        this.provider_id = provider_id;
    }

    public Date getDate_time() {
        return date_time;
    }

    public void setDate_time(Date date_time) {
        this.date_time = date_time;
    }

    public int getCount(){
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getModel_id(){
        return this.model_id;
    }

    public void setModel_id(int model_id) {
        this.model_id = model_id;
    }

    public int getPurchase_price(){
        return this.purchase_price;
    }

    public void setPurchase_price(int purchase_price) {
        this.purchase_price = purchase_price;
    }

    public int getPrice(){
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStatus_id(){
        return this.status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

    public OrderStatus getOrder_status(){
        return this.orderStatus;
    }

    public void setOrder_Status(OrderStatus orderStatus) {
        this.orderStatus =orderStatus;
    }

}
