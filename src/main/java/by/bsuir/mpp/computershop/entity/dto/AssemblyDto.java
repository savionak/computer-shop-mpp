package by.bsuir.mpp.computershop.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Min;

import static by.bsuir.mpp.computershop.utils.ValidationConstants.CANNOT_BE_NEGATIVE_MESSAGE;

public class AssemblyDto extends BaseDto<Long> {
    private OrderDto order;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long cost;

    @Min(value = 0, message = CANNOT_BE_NEGATIVE_MESSAGE)
    private Long count;

    public OrderDto getOrder() {
        return this.order;
    }

    public void setOrder(OrderDto order) {
        this.order = order;
    }

    public Long getCost() {
        return this.cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public Long getCount() {
        return this.count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
