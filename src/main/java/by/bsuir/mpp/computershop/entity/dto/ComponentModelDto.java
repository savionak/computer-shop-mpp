package by.bsuir.mpp.computershop.entity.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import static by.bsuir.mpp.computershop.utils.ValidationConstants.*;

public class ComponentModelDto extends BaseDto {
    @NotNull(message = CANNOT_BE_NULL_MESSAGE)
    private ComponentTypeDto type;

    @NotNull(message = CANNOT_BE_NULL_MESSAGE)
    @Pattern(regexp = NON_EMPTY_STRING_REGEX, message = CANNOT_BE_EMPTY_MESSAGE)
    private String name;

    private String description;

    private Boolean removed;

    public ComponentTypeDto getType() {
        return this.type;
    }

    public void setType(ComponentTypeDto type) {
        this.type = type;
    }

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
}
