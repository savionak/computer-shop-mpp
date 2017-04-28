package by.bsuir.mpp.computershop.entity;

import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

import static by.bsuir.mpp.computershop.utils.ValidationConstants.CANNOT_BE_NEGATIVE_MESSAGE;
import static by.bsuir.mpp.computershop.utils.ValidationConstants.CANNOT_BE_NULL_MESSAGE;

@Entity
@Table(name = "import")
@DynamicInsert
public class Import extends BaseEntity<Long> {
    @NotNull(message = CANNOT_BE_NULL_MESSAGE)
    @ManyToOne
    @JoinColumn(name = "provider_id", nullable = false)
    private Provider provider;

    @NotNull(message = CANNOT_BE_NULL_MESSAGE)
    @ManyToOne
    @JoinColumn(name = "model_id", nullable = false)
    private ComponentModel model;

    @Column(name = "import_date", nullable = false)
    private Timestamp importDate;

    @NotNull(message = CANNOT_BE_NULL_MESSAGE)
    @Min(value = 0, message = CANNOT_BE_NEGATIVE_MESSAGE)
    @Column(name = "count", nullable = false)
    private Long count;

    @NotNull(message = CANNOT_BE_NULL_MESSAGE)
    @Min(value = 0, message = CANNOT_BE_NEGATIVE_MESSAGE)
    @Column(name = "purchase_price", nullable = false)
    private Long purchasePrice;

    @Min(value = 0, message = CANNOT_BE_NEGATIVE_MESSAGE)
    @Column(name = "price")
    private Long price;

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
}
