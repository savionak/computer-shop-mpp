package by.bsuir.mpp.computershop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "order_component")

public class OrderComponent extends BaseEntity<Long>{

    @Column(nullable = false)
    private int order_id;

    @Column(nullable = false)
    private int component_id;

    @Column(nullable = false)
    private int count;


    public int getOrder_id(){
        return this.order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getComponent_id(){
        return this.component_id;
    }

    public void setComponent_id(int component_id) {
        this.component_id = component_id;
    }

    public int getCount(){
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
