package by.bsuir.mpp.computershop.entity;


import javax.persistence.*;

@Entity
@Table(name = "inventory_item")

public class InventoryItem extends BaseEntity<Long> {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stocktaking_id", nullable = false)
    private Inventory stocktaking;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "component_id", nullable = false)
    private ComponentStore component;

    @Column(name = "real_count",nullable = false)
    private int realCount;

    public Inventory getStocktaking(){
        return this.stocktaking;
    }
    public void setStocktaking(Inventory stocktaking) {
        this.stocktaking = stocktaking;
    }

    public ComponentStore getComponent(){
        return this.component;
    }
    public void setComponent(ComponentStore component) {
        this.component = component;
    }

    public int getRealCount(){
        return this.realCount;
    }
    public void setRealCount(int realCount) {
        this.realCount = realCount;
    }

}
