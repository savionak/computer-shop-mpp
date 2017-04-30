package by.bsuir.mpp.computershop.dto.full;

import by.bsuir.mpp.computershop.dto.brief.AssemblyBriefDto;
import by.bsuir.mpp.computershop.dto.brief.BaseBriefDto;
import by.bsuir.mpp.computershop.dto.brief.CustomerBriefDto;
import by.bsuir.mpp.computershop.dto.brief.ExportBriefDto;
import by.bsuir.mpp.computershop.entity.Order.Status;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.List;

import static by.bsuir.mpp.computershop.utils.ValidationConstants.CANNOT_BE_NULL_MESSAGE;

public class OrderFullDto extends BaseBriefDto {

    @NotNull(message = CANNOT_BE_NULL_MESSAGE)
    private CustomerBriefDto customer;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long cost;

    private Timestamp orderDate;

    @NotNull(message = CANNOT_BE_NULL_MESSAGE)
    private Status status;

    private ExportBriefDto export;

    private List<AssemblyBriefDto> assemblies;

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

    public ExportBriefDto getExport() {
        return export;
    }

    public void setExport(ExportBriefDto export) {
        this.export = export;
    }

    public List<AssemblyBriefDto> getAssemblies() {
        return assemblies;
    }

    public void setAssemblies(List<AssemblyBriefDto> assemblies) {
        this.assemblies = assemblies;
    }
}
