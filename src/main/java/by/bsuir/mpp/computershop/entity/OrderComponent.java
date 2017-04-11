package by.bsuir.mpp.computershop.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "order_component", catalog = "computer_shop")
@AssociationOverrides({
        @AssociationOverride(name = "id.order", joinColumns = @JoinColumn(name = "order_id")),
        @AssociationOverride(name = "id.component", joinColumns = @JoinColumn(name = "component_id"))})

public class OrderComponent implements Serializable {


    @EmbeddedId
    private OrderComponentPK id = new OrderComponentPK();

    @Id
    @ManyToOne
    @JoinColumn(name = "order_id",nullable = false)
    private Order orderOrder;

    @Id
    @ManyToOne
    @JoinColumn(name = "component_id",nullable = false)
    private ComponentStore orderComponent;

    @Column(name = "count",nullable = false)
    private int count;


    public OrderComponentPK getId(){
        return this.id;
    }
    public void setId(OrderComponentPK count) {
        this.id = id;
    }

    @Transient
    public Order getOrder(){
        return getId().getOrder();
    }
    public void setOrder(Order orderOrder) {
        getId().setOrder(orderOrder);
    }

    @Transient
    public ComponentStore getComponent(){
        return getId().getComponent();
    }
    public void setComponent(ComponentStore orderComponent) {
        getId().setComponent(orderComponent);
    }

    public int getCount(){
        return this.count;
    }
    public void setCount(int count) {
        this.count = count;
    }

}
