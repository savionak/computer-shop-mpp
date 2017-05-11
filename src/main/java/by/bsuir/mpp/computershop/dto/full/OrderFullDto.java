package by.bsuir.mpp.computershop.dto.full;

import by.bsuir.mpp.computershop.dto.brief.CustomerBriefDto;
import by.bsuir.mpp.computershop.entity.Order.Status;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

import static by.bsuir.mpp.computershop.utils.ValidationConstants.CANNOT_BE_EMPTY_MESSAGE;
import static by.bsuir.mpp.computershop.utils.ValidationConstants.CANNOT_BE_NULL_MESSAGE;

public class OrderFullDto extends BaseFullDto<Long> {

    @Valid
    @NotNull(message = CANNOT_BE_NULL_MESSAGE)
    private CustomerBriefDto customer;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long cost;

    @NotNull(message = CANNOT_BE_NULL_MESSAGE)
    private Timestamp orderDate;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Status status;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Boolean canceled;

    @NotEmpty(message = CANNOT_BE_EMPTY_MESSAGE)
    private String exportAddress;

    public CustomerBriefDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerBriefDto customer) {
        this.customer = customer;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp ordDate) {
        this.orderDate = ordDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Boolean getCanceled() {
        return canceled;
    }

    public void setCanceled(Boolean canceled) {
        this.canceled = canceled;
    }

    public String getExportAddress() {
        return exportAddress;
    }

    public void setExportAddress(String exportAddress) {
        this.exportAddress = exportAddress;
    }
}
