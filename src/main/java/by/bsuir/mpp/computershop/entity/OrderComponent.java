package by.bsuir.mpp.computershop.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "order_component")
public class OrderComponent implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @Id
    @ManyToOne
    @JoinColumn(name = "component_id", nullable = false)
    private ComponentStore component;

    @Column(name = "count", nullable = false)
    private int count;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public ComponentStore getComponent() {
        return component;
    }

    public void setComponent(ComponentStore component) {
        this.component = component;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
