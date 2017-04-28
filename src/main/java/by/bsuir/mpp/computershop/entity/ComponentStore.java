package by.bsuir.mpp.computershop.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import static by.bsuir.mpp.computershop.utils.ValidationConstants.CANNOT_BE_NEGATIVE_MESSAGE;
import static by.bsuir.mpp.computershop.utils.ValidationConstants.CANNOT_BE_NULL_MESSAGE;

@Entity
@Table(name = "component_store")
public class ComponentStore extends BaseEntity<Long> {
    @NotNull(message = CANNOT_BE_NULL_MESSAGE)
    @ManyToOne
    @JoinColumn(name = "model_id", nullable = false)
    private ComponentModel model;

    @Min(value = 0, message = CANNOT_BE_NEGATIVE_MESSAGE)
    @Column(name = "price")
    private int price;

    @NotNull(message = CANNOT_BE_NULL_MESSAGE)
    @Min(value = 0, message = CANNOT_BE_NEGATIVE_MESSAGE)
    @Column(name = "count")
    private int count;

    public ComponentModel getModel() {
        return this.model;
    }

    public void setModel(ComponentModel model) {
        this.model = model;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
