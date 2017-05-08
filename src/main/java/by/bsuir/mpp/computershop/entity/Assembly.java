package by.bsuir.mpp.computershop.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "assembly")
public class Assembly extends BaseEntity<Long> {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(name = "cost", nullable = false,
            insertable = false, updatable = false)
    private Long cost;

    @Column(name = "count", nullable = false)
    private Long count;

    @OneToMany(mappedBy = "assembly", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<AssemblyComponent> components;

    public Order getOrder() {
        return this.order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Long getCost() {
        return this.cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public Long getCount() {
        return this.count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public List<AssemblyComponent> getComponents() {
        return components;
    }

    public void setComponents(List<AssemblyComponent> components) {
        this.components = components;
    }
}
