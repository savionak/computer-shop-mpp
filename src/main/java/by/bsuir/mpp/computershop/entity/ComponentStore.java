package by.bsuir.mpp.computershop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "component_store")
public class ComponentStore extends BaseEntity<Long> {

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "model_id", nullable = false)
    private ComponentModel model;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "count", nullable = false)
    private int count;

    @JsonIgnore
    @Transient
    private Long newModelId;

    @JsonProperty(value = "modelId")
    public Long getModelId() {
        return this.model.getId();
    }

    @JsonProperty(value = "modelId")
    public void setModelId(Long id) {
        this.newModelId = id;
    }

    public Long getNewModelId() {
        return this.newModelId;
    }

    public void setComponentModel(ComponentModel componentModel) {
        this.model = componentModel;
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
