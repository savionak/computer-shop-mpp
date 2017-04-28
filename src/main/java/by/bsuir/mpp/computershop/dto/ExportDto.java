package by.bsuir.mpp.computershop.dto;

import java.sql.Timestamp;

public class ExportDto extends BaseDto {
    private Long orderId;

    private Timestamp exportDate;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Timestamp getExportDate() {
        return exportDate;
    }

    public void setExportDate(Timestamp exportDate) {
        this.exportDate = exportDate;
    }
}
