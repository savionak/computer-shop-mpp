package by.bsuir.mpp.computershop.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "component_store")

public class ComponentStore extends BaseEntity<Long>{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "model_id", nullable = false)
    private ComponentModel modelId;

    @Column(name = "price",nullable = false)
    private int price;

    @Column(name = "count",nullable = false)
    private int count;

    @OneToMany(mappedBy = "componentId", cascade = CascadeType.ALL)
    private List<InventoryItem> inventoryItems;

    public List<InventoryItem> getInventoryItems(){return inventoryItems;}
    public void setInventoryItems(List<InventoryItem> inventoryItems){this.inventoryItems = inventoryItems;}

    public ComponentModel getModelId(){
        return this.modelId;
    }
    public void setModelId(ComponentModel modelId) {
        this.modelId = modelId;
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
