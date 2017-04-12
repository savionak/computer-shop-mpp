package by.bsuir.mpp.computershop.entity;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
//@Embeddable
public class OrderComponentPK implements  java.io.Serializable  {

    private static final long serialVersionID = 1L;

    @ManyToOne
    private Order orderOrder;

    @ManyToOne
    private ComponentStore orderComponent;

    public Order getOrder() {
        return this.orderOrder;
    }

    public void setOrder(Order orderOrder) {
        this.orderOrder = orderOrder;
    }

    public ComponentStore getComponent() {
        return this.orderComponent;
    }

    public void setComponent(ComponentStore orderComponent) {
        this.orderComponent = orderComponent;
    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderComponentPK that = (OrderComponentPK) o;

        if (orderOrder != null ? !orderOrder.equals(that.orderOrder) : that.orderOrder != null) return false;
        if (orderComponent != null ? !orderComponent.equals(that.orderComponent) : that.orderComponent != null)
            return false;

        return true;
    }

    public int hashCode() {
        int result;
        result = (orderOrder != null ? orderOrder.hashCode() : 0);
        result = 31 * result + (orderComponent != null ? orderComponent.hashCode() : 0);
        return result;

    }
}
