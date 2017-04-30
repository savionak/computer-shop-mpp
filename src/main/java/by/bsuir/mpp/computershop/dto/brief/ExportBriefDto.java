package by.bsuir.mpp.computershop.dto.brief;

import java.sql.Timestamp;

public class ExportBriefDto extends BaseBriefDto<Long> {

    private OrderBriefDto order;

    private Timestamp exportDate;

    private String address;

    private Boolean done;

    public OrderBriefDto getOrder() {
        return order;
    }

    public void setOrder(OrderBriefDto order) {
        this.order = order;
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
