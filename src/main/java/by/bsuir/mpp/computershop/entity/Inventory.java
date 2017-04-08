package by.bsuir.mpp.computershop.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "inventory")
public class Inventory extends BaseEntity<Long>{

    @Column(name = "st_date",nullable = false)
    private Date stDate;

    @Column(name = "saldo",nullable = false)
    private int saldo;

    @OneToMany(mappedBy = "stocktakingId", cascade = CascadeType.ALL)
    private List<InventoryItem> inventoryItems;

    public List<InventoryItem> getInventoryItems(){return inventoryItems;}
    public void setInventoryItems(List<InventoryItem> inventoryItems){this.inventoryItems = inventoryItems;}

    public Date getStDate(){
        return this.stDate;
    }
    public void setStDate(Date stDate) {
        this.stDate = stDate;
    }

    public int getSaldo() {
        return saldo;
    }
    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

}
