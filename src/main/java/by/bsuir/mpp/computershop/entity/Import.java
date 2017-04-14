package by.bsuir.mpp.computershop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "import")
public class Import extends BaseEntity<Long> {

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "provider_id", nullable = false)
    private Provider provider;

    @Column(name = "date_time", nullable = false)
    private Timestamp dateTime;

    @Column(name = "count", nullable = false)
    private int count;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "model_id", nullable = false)
    private ComponentModel model;

    @Column(name = "purchase_price", nullable = false)
    private int purchasePrice;

    @Column(name = "price")
    private int price;

    @Column(name = "status", columnDefinition = "ENUM ('REGISTERED', 'FINISHED')", nullable = false)
    @Enumerated(EnumType.STRING)
    private ImportStatus status;

    @Transient
    private Long newProviderId;

    @JsonProperty(value = "providerId")
    public Long getProviderId() {
        return provider.getId();
    }

    @JsonProperty(value = "providerId")
    public void setProviderId(Long id) {
        newProviderId = id;
    }

    @JsonProperty(value = "modelId")
    public Long getModelId() {
        return model.getId();
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ComponentModel getModel() {
        return this.model;
    }

    public void setModel(ComponentModel model) {
        this.model = model;
    }

    public int getPurchasePrice() {
        return this.purchasePrice;
    }

    public void setPurchasePrice(int purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ImportStatus getStatus() {
        return this.status;
    }

    public void setStatus(ImportStatus status) {
        this.status = status;
    }

    public enum ImportStatus {
        REGISTERED {
            public String toString() {
                return "Зарегистрирован";
            }
        },
        FINISHED {
            public String toString() {
                return "Принят";
            }
        };

        public abstract String toString();
    }
}
