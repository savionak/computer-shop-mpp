package by.bsuir.mpp.computershop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "export")
public class Export extends BaseEntity<Long>{

    @Column(name = "order_id",nullable = false)
    private int orderId;

    @Column(name = "exp_date",nullable = false)
    private Date expDate;

    public int getOrderId(){
        return this.orderId;
    }

    public void setOrderId(int customer_id) {
        this.orderId = orderId;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }



}
