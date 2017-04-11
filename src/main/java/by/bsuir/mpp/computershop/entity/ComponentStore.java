package by.bsuir.mpp.computershop.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "component_store")

public class ComponentStore extends BaseEntity<Long>{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "model_id", nullable = false)
    private ComponentModel componentModel;

    @Column(name = "price",nullable = false)
    private int price;

    @Column(name = "count",nullable = false)
    private int count;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "component", cascade = CascadeType.ALL)
    private List<InventoryItem> inventoryItems;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orderComponent", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<OrderComponent>  orderComponents;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "assemblyComponent", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<AssemblyComponent>  assemblyComponents;

    public List<AssemblyComponent> getAssemblyComponents(){return assemblyComponents;}
    public void setAssemblyComponents(List<AssemblyComponent> assemblyComponents){this.assemblyComponents = assemblyComponents;}

    public List<OrderComponent> getOrderComponents(){return orderComponents;}
    public void setOrderComponents(List<OrderComponent> orderComponents){this.orderComponents = orderComponents;}

    public List<InventoryItem> getInventoryItems(){return inventoryItems;}
    public void setInventoryItems(List<InventoryItem> inventoryItems){this.inventoryItems = inventoryItems;}

    public ComponentModel getComponentModel(){
        return this.componentModel;
    }
    public void setComponentModel(ComponentModel componentModel) {
        this.componentModel = componentModel;
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
