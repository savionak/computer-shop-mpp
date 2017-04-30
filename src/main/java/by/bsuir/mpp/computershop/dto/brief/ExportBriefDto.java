package by.bsuir.mpp.computershop.dto.brief;

import java.sql.Timestamp;

public class ExportBriefDto extends BaseBriefDto<Long> {

    private Long orderId;

    private String customerName;

    private Long orderCost;

    private Timestamp exportDate;

    private String address;

    private Boolean done;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Long getOrderCost() {
        return orderCost;
    }

    public void setOrderCost(Long orderCost) {
        this.orderCost = orderCost;
    }

    public Timestamp getExportDate() {
        return exportDate;
    }

    public void setExportDate(Timestamp exportDate) {
        this.exportDate = exportDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }
}
