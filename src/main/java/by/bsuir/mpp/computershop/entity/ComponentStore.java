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

    @OneToMany(mappedBy = "component", cascade = CascadeType.ALL)
    private List<InventoryItem> inventoryItems;

    @OneToMany(mappedBy = "orderComponent", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<OrderComponent>  orderComponents;

    public List<OrderComponent> getOrderComponents(){return orderComponents;}
    public void setOrderComponents(List<OrderComponent> orderComponents){this.orderComponents = orderComponents;}

    public List<InventoryItem> getInventoryItems(){return inventoryItems;}
    public void setInventoryItems(List<InventoryItem> inventoryItems){this.inventoryItems = inventoryItems;}

    public ComponentModel getModel(){
        return this.model;
    }
    public void setModel(ComponentModel model) {
        this.model = model;
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
