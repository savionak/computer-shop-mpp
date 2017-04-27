package by.bsuir.mpp.computershop.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
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

    @NotNull(message = "Cannot be null")
    @Column(name = "import_date", nullable = false)
    private Timestamp importDate;

    @NotNull(message = "Cannot be null")
    @Min(value = 0, message = "Count cannot be negative")
    @Column(name = "count", nullable = false)
    private long count;

    @NotNull(message = "Cannot be null")
    @Column(name = "purchase_price", nullable = false)
    private long purchasePrice;

    @Column(name = "price")
    private long price;

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

    public long getCount() {
        return this.count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public long getPurchasePrice() {
        return this.purchasePrice;
    }

    public void setPurchasePrice(long purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public long getPrice() {
        return this.price;
    }

    public void setPrice(long price) {
        this.price = price;
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
