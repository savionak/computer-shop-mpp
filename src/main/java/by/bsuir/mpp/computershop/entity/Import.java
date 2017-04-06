package by.bsuir.mpp.computershop.entity;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "import")
public class Import extends BaseEntity<Long> {

    @Column(nullable = false)
    private int customer_id;

    @Column(nullable = false)
    private int cost;

    @Column(nullable = false)
    private Date ord_date;

    @Column(nullable = false)
    private int status_id;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private ImportStatus importStatus;

    public int getCustomer_id(){
        return this.customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public Date getOrd_date() {
        return ord_date;
    }

    public void setOrd_date(Date ord_date) {
        this.ord_date = ord_date;
    }

    public int getCost(){
        return this.cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getStatus_id(){
        return this.status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

    public ImportStatus getImport_status(){
        return this.importStatus;
    }

    public void setImport_Status(ImportStatus importStatus) {
        this.importStatus =importStatus;
    }
}
