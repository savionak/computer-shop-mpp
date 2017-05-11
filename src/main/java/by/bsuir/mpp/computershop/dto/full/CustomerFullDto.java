package by.bsuir.mpp.computershop.dto.full;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.SafeHtml;

import javax.validation.constraints.NotNull;

import static by.bsuir.mpp.computershop.utils.ValidationConstants.CANNOT_BE_EMPTY_MESSAGE;
import static by.bsuir.mpp.computershop.utils.ValidationConstants.CANNOT_BE_NULL_MESSAGE;

public class CustomerFullDto extends BaseFullDto<Long> {

    @SafeHtml
    @NotEmpty(message = CANNOT_BE_EMPTY_MESSAGE)
    private String name;

    @SafeHtml
    private String description;

    @NotNull(message = CANNOT_BE_NULL_MESSAGE)
    private Boolean removed;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer ordersCount;

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
}
