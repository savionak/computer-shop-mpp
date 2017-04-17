package by.bsuir.mpp.computershop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@Table(name = "import")
public class Import extends BaseEntity<Long> {

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "provider_id", nullable = false)
    private Provider provider;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "model_id", nullable = false)
    private ComponentModel model;

    @NotNull
    @Column(name = "count", nullable = false)
    private int count;

    @NotNull
    @Column(name = "purchase_price", nullable = false)
    private int purchasePrice;

    @Column(name = "price")
    private int price;

    @NotNull
    @Column(name = "date_time", nullable = false)
    private Timestamp dateTime;

    @NotNull
    @Column(name = "status", columnDefinition = "ENUM ('REGISTERED', 'FINISHED')", nullable = false)
    @Enumerated(EnumType.STRING)
    private ImportStatus status;

    @JsonIgnore
    @Transient
    private Long newProviderId;

    @JsonIgnore
    @Transient
    private Long newModelId;

    @JsonProperty(value = "providerId")
    public Long getProviderId() {
        return provider.getId();
    }

    @JsonProperty(value = "providerId")
    public void setProviderId(Long id) {
        newProviderId = id;
    }

    @JsonProperty(value = "providerName")
    public String getProviderName() {
        return provider.getName();
    }

    @JsonProperty(value = "modelId")
    public Long getModelId() {
        return model.getId();
    }

    public Long getNewProviderId() {
        return newProviderId;
    }

    @JsonProperty(value = "modelId")
    public void setModelId(Long id) {
        newModelId = id;
    }

    public Long getNewModelId() {
        return newModelId;
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

    public void setProvider(Provider provider) {
        this.provider = provider;
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
