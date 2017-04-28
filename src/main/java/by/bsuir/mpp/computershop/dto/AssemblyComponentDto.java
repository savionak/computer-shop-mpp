package by.bsuir.mpp.computershop.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

import static by.bsuir.mpp.computershop.utils.ValidationConstants.CANNOT_BE_NEGATIVE_MESSAGE;
import static by.bsuir.mpp.computershop.utils.ValidationConstants.CANNOT_BE_NULL_MESSAGE;

public class AssemblyComponentDto implements Serializable {

    @NotNull(message = CANNOT_BE_NULL_MESSAGE)
    private ComponentStoreDto component;

    @NotNull(message = CANNOT_BE_NULL_MESSAGE)
    @Min(value = 0, message = CANNOT_BE_NEGATIVE_MESSAGE)
    private Long count;

    public ComponentStoreDto getComponent() {
        return component;
    }

    public void setComponent(ComponentStoreDto component) {
        this.component = component;
    }

    public Long getCount() {
        return this.count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
