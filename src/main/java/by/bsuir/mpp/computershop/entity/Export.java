package by.bsuir.mpp.computershop.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "export")
public class Export extends BaseEntity<Long>{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @Column(name = "exp_date",nullable = false)
    private Date expDate;

    public Order getOrder(){
        return this.order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }

    public Date getExpDate() {
        return expDate;
    }
    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }



}
