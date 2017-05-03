package by.bsuir.mpp.computershop.entity;

import javax.persistence.*;

@Entity
@Table(name = "component_store")
public class ComponentStore extends BaseEntity<Long> {

    @ManyToOne
    @JoinColumn(name = "model_id", nullable = false)
    private ComponentModel model;

    @Column(name = "price", nullable = false)
    private Long price;

    @Column(name = "count", nullable = false)
    private Long count;

    public ComponentModel getModel() {
        return this.model;
    }

    public void setModel(ComponentModel model) {
        this.model = model;
    }

    public Long getPrice() {
        return this.price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getCount() {
        return this.count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

}
