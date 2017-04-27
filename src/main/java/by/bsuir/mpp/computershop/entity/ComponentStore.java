package by.bsuir.mpp.computershop.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Table(name = "component_store")
public class ComponentStore extends BaseEntity<Long> {

    @ManyToOne
    @JoinColumn(name = "model_id", nullable = false)
    private ComponentModel model;

    @Min(value = 0, message = "Price cannot be negative")
    @Column(name = "price", nullable = false)
    private int price;

    @Min(value = 0, message = "Count cannot be negative")
    @Column(name = "count", nullable = false)
    private int count;

    @JsonProperty(value = "modelId")
    public Long getModelId() {
        return this.model.getId();
    }

    @JsonProperty(value = "modelId")
    public void setModelId(Long id) {
        this.model.setId(id);
    }

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
