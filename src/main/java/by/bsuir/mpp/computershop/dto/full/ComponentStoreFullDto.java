package by.bsuir.mpp.computershop.dto.full;

import by.bsuir.mpp.computershop.dto.brief.ComponentModelBriefDto;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import static by.bsuir.mpp.computershop.utils.ValidationConstants.CANNOT_BE_NEGATIVE_MESSAGE;
import static by.bsuir.mpp.computershop.utils.ValidationConstants.CANNOT_BE_NULL_MESSAGE;

public class ComponentStoreFullDto extends BaseFullDto<Long> {

    @Valid
    @NotNull(message = CANNOT_BE_NULL_MESSAGE)
    private ComponentModelBriefDto model;

    @NotNull(message = CANNOT_BE_NULL_MESSAGE)
    @Min(value = 0, message = CANNOT_BE_NEGATIVE_MESSAGE)
    private Long price;

    @NotNull(message = CANNOT_BE_NULL_MESSAGE)
    @Min(value = 0, message = CANNOT_BE_NEGATIVE_MESSAGE)
    private Long count;

    public ComponentModelBriefDto getModel() {
        return model;
    }

    public void setModel(ComponentModelBriefDto model) {
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
