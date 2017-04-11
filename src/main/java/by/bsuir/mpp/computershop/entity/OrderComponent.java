package by.bsuir.mpp.computershop.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "order_component")
@AssociationOverrides({
        @AssociationOverride(name = "orderOrder", joinColumns = @JoinColumn(name = "order_id")),
        @AssociationOverride(name = "orderComponent", joinColumns = @JoinColumn(name = "component_id"))})

public class OrderComponent implements Serializable {


    @EmbeddedId
    private OrderComponentPK Pk = new OrderComponentPK();

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

    public OrderComponentPK getPk(){
        return this.Pk;
    }
    public void setPk(OrderComponentPK count) {
        this.Pk = Pk;
    }

    @Transient
    public Order getOrder(){
        return getPk().getOrder();
    }
    public void setOrder(Order orderOrder) {
        getPk().setOrder(orderOrder);
    }

    @Transient
    public ComponentStore getComponent(){
        return getPk().getComponent();
    }
    public void setComponent(ComponentStore orderComponent) {
        getPk().setComponent(orderComponent);
    }

    public int getCount(){
        return this.count;
    }
    public void setCount(int count) {
        this.count = count;
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        OrderComponent that = (OrderComponent) o;

        if (getPk() != null ? !getPk().equals(that.getPk())
                : that.getPk() != null)
            return false;

        return true;
    }

    public int hashCode() {
        return (getPk() != null ? getPk().hashCode() : 0);
    }

}
