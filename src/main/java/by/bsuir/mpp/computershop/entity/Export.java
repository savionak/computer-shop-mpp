package by.bsuir.mpp.computershop.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "export")
public class Export extends BaseEntity<Long> {

    @OneToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @Column(name = "export_date", nullable = false)
    private Timestamp exportDate;

    @Column(name = "address", nullable = false)
    private String address;

    public Order getOrder() {
        return this.order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Timestamp getExportDate() {
        return exportDate;
    }

    public void setExportDate(Timestamp expDate) {
        this.exportDate = expDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
