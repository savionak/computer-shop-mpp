package by.bsuir.mpp.computershop.dto.full;

import by.bsuir.mpp.computershop.dto.brief.ComponentTypeBriefDto;
import org.hibernate.validator.constraints.SafeHtml;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import static by.bsuir.mpp.computershop.utils.ValidationConstants.*;

public class ComponentModelFullDto extends BaseFullDto<Long> {

    @Valid
    @NotNull(message = CANNOT_BE_NULL_MESSAGE)
    private ComponentTypeBriefDto type;

    @SafeHtml
    @NotNull(message = CANNOT_BE_NULL_MESSAGE)
    @Pattern(regexp = NON_EMPTY_STRING_REGEX, message = CANNOT_BE_EMPTY_MESSAGE)
    private String name;

    @SafeHtml
    private String description;

    @NotNull(message = CANNOT_BE_NULL_MESSAGE)
    private Boolean removed;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ComponentTypeBriefDto getType() {
        return type;
    }

    public void setType(ComponentTypeBriefDto type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getRemoved() {
        return removed;
    }

    public void setRemoved(Boolean removed) {
        this.removed = removed;
    }
}
