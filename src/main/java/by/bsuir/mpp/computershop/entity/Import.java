package by.bsuir.mpp.computershop.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "import")
public class Import extends BaseEntity<Long> {

    @ManyToOne
    @JoinColumn(name = "provider_id", nullable = false)
    private Provider provider;

    @ManyToOne
    @JoinColumn(name = "model_id", nullable = false)
    private ComponentModel model;

    @Column(name = "import_date", nullable = false)
    private Timestamp importDate;

    @Column(name = "count", nullable = false)
    private Long count;

    @Column(name = "purchase_price", nullable = false)
    private Long purchasePrice;

    @Column(name = "price", nullable = false)
    private Long price;

    @ManyToOne
    @JoinColumn(name = "store_id", nullable = false,
            insertable = false, updatable = false)
    private ComponentStore stored;

    public Provider getProvider() {
        return this.provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public ComponentModel getModel() {
        return this.model;
    }

    public void setModel(ComponentModel model) {
        this.model = model;
    }

    public Timestamp getImportDate() {
        return importDate;
    }

    public void setImportDate(Timestamp importDate) {
        this.importDate = importDate;
    }

    public Long getCount() {
        return this.count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Long getPurchasePrice() {
        return this.purchasePrice;
    }

    public void setPurchasePrice(Long purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Long getPrice() {
        return this.price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public ComponentStore getStored() {
        return stored;
    }

    public void setStored(ComponentStore stored) {
        this.stored = stored;
    }
}
