package by.bsuir.mpp.computershop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "order_component")

//МНОГОЕ-КО-МНОГИМ!!!!???

public class OrderComponent {

    @Column(name = "order_id",nullable = false)
    private int orderId;

    @Column(name = "component_id",nullable = false)
    private int componentId;

    @Column(name = "count",nullable = false)
    private int count;

    public int getOrderId(){
        return this.orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getComponentId(){
        return this.componentId;
    }

    public void setComponentId(int componentId) {
        this.componentId = componentId;
    }

    public int getCount(){
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
