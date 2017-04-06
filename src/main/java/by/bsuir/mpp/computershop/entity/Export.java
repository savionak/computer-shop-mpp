package by.bsuir.mpp.computershop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "export")
public class Export {

    @Column(nullable = false)
    private int order_id;

    @Column(nullable = false)
    private Date exp_date;

    public int getOrder_id(){
        return this.order_id;
    }

    public void setOrder_id(int customer_id) {
        this.order_id = order_id;
    }

    public Date getExp_date() {
        return exp_date;
    }

    public void setExp_date(Date exp_date) {
        this.exp_date = exp_date;
    }



}
