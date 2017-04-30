package by.bsuir.mpp.computershop.dto.full;

import by.bsuir.mpp.computershop.dto.brief.ComponentStoreBriefDto;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import static by.bsuir.mpp.computershop.utils.ValidationConstants.CANNOT_BE_NEGATIVE_MESSAGE;
import static by.bsuir.mpp.computershop.utils.ValidationConstants.CANNOT_BE_NULL_MESSAGE;

public class AssemblyComponentFullDto extends BaseFullDto<Long> {

    @Valid
    @NotNull(message = CANNOT_BE_NULL_MESSAGE)
    private ComponentStoreBriefDto component;

    @NotNull(message = CANNOT_BE_NULL_MESSAGE)
    @Min(value = 0, message = CANNOT_BE_NEGATIVE_MESSAGE)
    private Long count;

    public ComponentStoreBriefDto getComponent() {
        return component;
    }

    public void setComponent(ComponentStoreBriefDto component) {
        this.component = component;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
