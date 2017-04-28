package by.bsuir.mpp.computershop.dto;

import java.sql.Timestamp;

public class ExportDto extends BaseDto {
    private OrderDto order;

    private Timestamp exportDate;

    public OrderDto getOrder() {
        return this.order;
    }

    public void setOrder(OrderDto order) {
        this.order = order;
    }

    public Timestamp getExportDate() {
        return exportDate;
    }

    public void setExportDate(Timestamp expDate) {
        this.exportDate = expDate;
    }
}
