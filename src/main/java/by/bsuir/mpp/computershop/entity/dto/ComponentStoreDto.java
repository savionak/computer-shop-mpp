package by.bsuir.mpp.computershop.entity.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import static by.bsuir.mpp.computershop.utils.ValidationConstants.CANNOT_BE_NEGATIVE_MESSAGE;
import static by.bsuir.mpp.computershop.utils.ValidationConstants.CANNOT_BE_NULL_MESSAGE;

public class ComponentStoreDto extends BaseDto {
    @NotNull(message = CANNOT_BE_NULL_MESSAGE)
    private ComponentModelDto model;

    @Min(value = 0, message = CANNOT_BE_NEGATIVE_MESSAGE)
    private Long price;

    @NotNull(message = CANNOT_BE_NULL_MESSAGE)
    @Min(value = 0, message = CANNOT_BE_NEGATIVE_MESSAGE)
    private Long count;

    public ComponentModelDto getModel() {
        return this.model;
    }

    public void setModel(ComponentModelDto model) {
        this.model = model;
    }

    public Long getPrice() {
        return this.price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getCount() {
        return this.count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
