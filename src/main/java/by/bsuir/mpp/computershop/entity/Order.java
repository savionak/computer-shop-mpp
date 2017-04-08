package by.bsuir.mpp.computershop.entity;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "import")
public class Order extends BaseEntity<Long> {

    @Column(name = "customer_id",nullable = false)
    private int customerId;

    @Column(name = "cost",nullable = false)
    private int cost;

    @Column(name = "ord_date",nullable = false)
    private Date ordDate;

    @Column(name = "status_id",nullable = false)
    private int statusId;

    @Column(name = "import_status",nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private ImportStatus importStatus;

    public int getCustomerId(){
        return this.customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Date getOrdDate() {
        return ordDate;
    }

    public void setOrdDate(Date ordDate) {
        this.ordDate = ordDate;
    }

    public int getCost(){
        return this.cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getStatusId(){
        return this.statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public ImportStatus getImport_status(){
        return this.importStatus;
    }

    public void setImport_Status(ImportStatus importStatus) {
        this.importStatus =importStatus;
    }
}
