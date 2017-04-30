package by.bsuir.mpp.computershop.dto.full;

import by.bsuir.mpp.computershop.dto.brief.BaseBriefDto;
import by.bsuir.mpp.computershop.dto.brief.OrderBriefDto;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

import static by.bsuir.mpp.computershop.utils.ValidationConstants.CANNOT_BE_NULL_MESSAGE;

public class ExportFullDto extends BaseBriefDto {

    @NotNull(message = CANNOT_BE_NULL_MESSAGE)
    private OrderBriefDto order;

    @NotNull(message = CANNOT_BE_NULL_MESSAGE)
    private Timestamp exportDate;

    @NotNull(message = CANNOT_BE_NULL_MESSAGE)
    private String address;

    @NotNull(message = CANNOT_BE_NULL_MESSAGE)
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
