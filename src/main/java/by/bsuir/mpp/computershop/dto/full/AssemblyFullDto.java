package by.bsuir.mpp.computershop.dto.full;

import by.bsuir.mpp.computershop.dto.brief.AssemblyComponentBriefDto;
import by.bsuir.mpp.computershop.dto.brief.OrderBriefDto;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

import static by.bsuir.mpp.computershop.utils.ValidationConstants.CANNOT_BE_NEGATIVE_MESSAGE;
import static by.bsuir.mpp.computershop.utils.ValidationConstants.CANNOT_BE_NULL_MESSAGE;

public class AssemblyFullDto extends BaseFullDto<Long> {

    @Valid
    @NotNull(message = CANNOT_BE_NULL_MESSAGE)
    private OrderBriefDto order;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long cost;

    @NotNull(message = CANNOT_BE_NULL_MESSAGE)
    @Min(value = 0, message = CANNOT_BE_NEGATIVE_MESSAGE)
    private Long count;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<AssemblyComponentBriefDto> components;

    public OrderBriefDto getOrder() {
        return order;
    }

    public void setOrder(OrderBriefDto order) {
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

    public List<AssemblyComponentBriefDto> getComponents() {
        return components;
    }

    public void setComponents(List<AssemblyComponentBriefDto> components) {
        this.components = components;
    }
}
