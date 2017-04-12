package by.bsuir.mpp.computershop.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "component_store")
public class ComponentStore extends BaseEntity<Long>{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "model_id", nullable = false)
    private ComponentModel model;

    @Column(name = "price",nullable = false)
    private int price;

    @Column(name = "count",nullable = false)
    private int count;

    public ComponentModel getComponentModel(){
        return this.model;
    }
    public void setComponentModel(ComponentModel componentModel) {
        this.model = componentModel;
    }

    public int getPrice(){
        return this.price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount(){
        return this.count;
    }
    public void setCount(int count) {
        this.count = count;
    }

}
