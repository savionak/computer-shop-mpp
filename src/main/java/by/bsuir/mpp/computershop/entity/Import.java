package by.bsuir.mpp.computershop.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "import")
public class Import extends BaseEntity<Long> {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "provider_id", nullable = false)
    private Provider provider;

    @Column(name = "date_time",nullable = false)
    private Timestamp dateTime;

    @Column(name = "count",nullable = false)
    private int count;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "model_id", nullable = false)
    private ComponentModel model;

    @Column(name = "purchase_price",nullable = false)
    private int purchasePrice;

    @Column(name = "price",nullable = false)
    private int price;

    @Column(columnDefinition = "ENUM ('REGISTERED', 'FINISHED')", name = "status",nullable = false)
    @Enumerated(EnumType.STRING)
    private ImportStatus status;

    public Provider getProvider(){
        return this.provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
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

    public  enum ImportStatus
    {
        REGISTERED{
            public String toString() {
                return "зарегистрирован";
            }
        },
        FINISHED{
            public String toString() {
                return "принят";
            }
        };
        public abstract String toString();

    }
}
