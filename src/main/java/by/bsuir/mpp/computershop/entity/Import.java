package by.bsuir.mpp.computershop.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "order")
public class Import extends BaseEntity<Long> {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "provider_id", nullable = false)
    private Provider provider;

    @Column(name = "date_time",nullable = false)
    private Date dateTime;

    @Column(name = "count",nullable = false)
    private int count;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "model_id", nullable = false)
    private ComponentModel model;

    @Column(name = "purchase_price",nullable = false)
    private int purchasePrice;

    @Column(name = "price",nullable = false)
    private int price;

    @Column(name = "status",nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private ImportStatus status;

    public Provider getProvider(){
        return this.provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public int getCount(){
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ComponentModel getModel(){
        return this.model;
    }

    public void setModel(ComponentModel model) {
        this.model = model;
    }

    public int getPurchasePrice(){
        return this.purchasePrice;
    }

    public void setPurchasePrice(int purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public int getPrice(){
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ImportStatus getStatus(){
        return this.status;
    }

    public void setStatus(ImportStatus status) {
        this.status =status;
    }

}
