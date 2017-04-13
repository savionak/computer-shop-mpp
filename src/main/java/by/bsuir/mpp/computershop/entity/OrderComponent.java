package by.bsuir.mpp.computershop.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "order_component")
public class OrderComponent implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order orderOrder;

    @Id
    @ManyToOne
    @JoinColumn(name = "component_id", nullable = false)
    private ComponentStore orderComponent;

    @Column(name = "count", nullable = false)
    private int count;

    public Order getOrder() {
        return orderOrder;
    }

    public void setOrder(Order orderOrder) {
        this.orderOrder = orderOrder;
    }

    public ComponentStore getComponent() {
        return orderComponent;
    }

    public void setComponent(ComponentStore orderComponent) {
        this.orderComponent = orderComponent;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
