package by.bsuir.mpp.computershop.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "inventory")
public class Inventory extends BaseEntity<Long> {

    @Column(name = "st_date", nullable = false)
    private Timestamp stDate;

    @Column(name = "saldo", nullable = false)
    private long saldo;

    @OneToMany(mappedBy = "stocktaking", cascade = CascadeType.ALL)
    private List<InventoryItem> items;

    public List<InventoryItem> getItems() {
        return items;
    }

    public void setItems(List<InventoryItem> inventoryItems) {
        this.items = inventoryItems;
    }

    public Timestamp getStDate() {
        return this.stDate;
    }

    public void setStDate(Timestamp stDate) {
        this.stDate = stDate;
    }

    public long getSaldo() {
        return saldo;
    }

    public void setSaldo(long saldo) {
        this.saldo = saldo;
    }
}
