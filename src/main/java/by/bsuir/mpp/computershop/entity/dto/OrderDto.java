package by.bsuir.mpp.computershop.entity.dto;

import by.bsuir.mpp.computershop.entity.Order.Status;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.List;

import static by.bsuir.mpp.computershop.utils.ValidationConstants.CANNOT_BE_NULL_MESSAGE;

public class OrderDto extends BaseDto {
    @NotNull(message = CANNOT_BE_NULL_MESSAGE)
    private CustomerDto customer;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long cost;

    private Timestamp orderDate;

    private Status status;

    private Boolean canceled = false;

    private List<ExportDto> exports;

    private List<AssemblyDto> assemblies;

    public CustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDto customer) {
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

    public Boolean isCanceled() {
        return canceled;
    }

    public void setCanceled(Boolean canceled) {
        this.canceled = canceled;
    }

    public List<ExportDto> getExports() {
        return exports;
    }

    public void setExports(List<ExportDto> exports) {
        this.exports = exports;
    }

    public List<AssemblyDto> getAssemblies() {
        return assemblies;
    }

    public void setAssemblies(List<AssemblyDto> assemblyParcels) {
        this.assemblies = assemblyParcels;
    }
}
