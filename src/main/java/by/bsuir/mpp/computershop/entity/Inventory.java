package by.bsuir.mpp.computershop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "inventory")
public class Inventory extends BaseEntity<Long>{

    @Column(nullable = false)
    private Date st_date;

    @Column(nullable = false)
    private int saldo;

    public Date getSt_date(){
        return this.st_date;
    }

    public void setSt_date(Date st_date) {
        this.st_date = st_date;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

}
