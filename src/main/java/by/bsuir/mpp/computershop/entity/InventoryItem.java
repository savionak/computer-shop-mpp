package by.bsuir.mpp.computershop.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "inventory_item")

public class InventoryItem extends BaseEntity<Long> {

    @Column(nullable = false)
    private int stocktaking_id;

    @Column(nullable = false)
    private int component_id;

    @Column(nullable = false)
    private int real_count;

    public int getStocktaking_id(){
        return this.stocktaking_id;
    }

    public void setStocktaking_id(int stocktaking_id) {
        this.stocktaking_id = stocktaking_id;
    }

    public int getComponent_id(){
        return this.component_id;
    }

    public void setComponent_id(int component_id) {
        this.component_id = component_id;
    }

    public int getReal_count(){
        return this.real_count;
    }

    public void setReal_count(int real_count) {
        this.real_count = real_count;
    }

}
