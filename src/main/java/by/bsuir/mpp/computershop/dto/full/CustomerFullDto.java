package by.bsuir.mpp.computershop.dto.full;

import by.bsuir.mpp.computershop.dto.brief.BaseBriefDto;
import by.bsuir.mpp.computershop.dto.brief.OrderBriefDto;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

import static by.bsuir.mpp.computershop.utils.ValidationConstants.*;

public class CustomerFullDto extends BaseBriefDto {

    @NotNull(message = CANNOT_BE_NULL_MESSAGE)
    @Pattern(regexp = NON_EMPTY_STRING_REGEX, message = CANNOT_BE_EMPTY_MESSAGE)
    private String name;

    private String description;

    private Boolean removed;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer ordersCount;

    private List<OrderBriefDto> orders;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean isRemoved() {
        return removed;
    }

    public void setRemoved(Boolean removed) {
        this.removed = removed;
    }

    public Integer getOrdersCount() {
        return ordersCount;
    }

    public void setOrdersCount(Integer ordersCount) {
        this.ordersCount = ordersCount;
    }

    public List<OrderBriefDto> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderBriefDto> orders) {
        this.orders = orders;
    }
}
