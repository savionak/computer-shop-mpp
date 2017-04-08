package by.bsuir.mpp.computershop.entity;


import javax.persistence.*;

@Entity
@Table(name = "inventory_item")

public class InventoryItem extends BaseEntity<Long> {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stocktaking_id", nullable = false)
    private Inventory stocktakingId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "component_id", nullable = false)
    private ComponentStore componentId;

    @Column(name = "real_count",nullable = false)
    private int realCount;

    public Inventory getStocktakingId(){
        return this.stocktakingId;
    }
    public void setStocktakingId(Inventory stocktakingId) {
        this.stocktakingId = stocktakingId;
    }

    public ComponentStore getComponentId(){
        return this.componentId;
    }
    public void setComponentId(ComponentStore componentId) {
        this.componentId = componentId;
    }

    public int getRealCount(){
        return this.realCount;
    }
    public void setRealCount(int realCount) {
        this.realCount = realCount;
    }

}
