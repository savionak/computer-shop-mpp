package by.bsuir.mpp.computershop.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "order")
public class Import extends BaseEntity<Long> {

    @Column(name = "provider_id",nullable = false)
    private int providerId;

    @Column(name = "date_time",nullable = false)
    private Date dateTime;

    @Column(name = "count",nullable = false)
    private int count;

    @Column(name = "model_id",nullable = false)
    private int modelId;

    @Column(name = "purchase_price",nullable = false)
    private int purchasePrice;

    @Column(name = "price",nullable = false)
    private int price;

    @Column(name = "status_id",nullable = false)
    private int statusId;

    @Column(name = "order_status",nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private OrderStatus orderStatus;

    public int getProviderId(){
        return this.providerId;
    }

    public void setProviderId(int name) {
        this.providerId = providerId;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public int getCount(){
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getModelId(){
        return this.modelId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    public int getPurchasePrice(){
        return this.purchasePrice;
    }

    public void setPurchasePrice(int purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public int getPrice(){
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStatusId(){
        return this.statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public OrderStatus getOrder_status(){
        return this.orderStatus;
    }

    public void setOrder_Status(OrderStatus orderStatus) {
        this.orderStatus =orderStatus;
    }

}
