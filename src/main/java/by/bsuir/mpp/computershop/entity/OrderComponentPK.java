package by.bsuir.mpp.computershop.entity;

import javax.persistence.ManyToOne;
import java.io.Serializable;

public class OrderComponentPK implements Serializable{

    private static final long serialVersionID = 1L;

    @ManyToOne
    private Order orderOrder;

    @ManyToOne
    private ComponentStore orderComponent;

    public Order getOrder(){
        return this.orderOrder;
    }
    public void setOrder(Order orderOrder) {
        this.orderOrder = orderOrder;
    }

    public ComponentStore getComponent(){
        return this.orderComponent;
    }
    public void setComponent(ComponentStore orderComponent) {
        this.orderComponent = orderComponent;
    }


}
