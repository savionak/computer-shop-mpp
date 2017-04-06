package by.bsuir.mpp.computershop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "component_store")

public class ComponentStore extends BaseEntity<Long>{

    @Column(nullable = false)
    private int model_id;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private int count;

    public int getModel_id(){
        return this.model_id;
    }

    public void setModel_id(int model_id) {
        this.model_id = model_id;
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
