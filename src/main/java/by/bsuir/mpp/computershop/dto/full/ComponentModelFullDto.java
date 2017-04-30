package by.bsuir.mpp.computershop.dto.full;

import by.bsuir.mpp.computershop.dto.brief.ComponentStoreBriefDto;
import by.bsuir.mpp.computershop.dto.brief.ComponentTypeBriefDto;
import by.bsuir.mpp.computershop.dto.brief.ImportBriefDto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

import static by.bsuir.mpp.computershop.utils.ValidationConstants.*;

public class ComponentModelFullDto extends BaseFullDto<Long> {

    @Valid
    @NotNull(message = CANNOT_BE_NULL_MESSAGE)
    private ComponentTypeBriefDto type;

    @NotNull(message = CANNOT_BE_NULL_MESSAGE)
    @Pattern(regexp = NON_EMPTY_STRING_REGEX, message = CANNOT_BE_EMPTY_MESSAGE)
    private String name;

    private String description;

    private Boolean removed;

    private List<ComponentStoreBriefDto> storedComponents;

    private List<ImportBriefDto> imports;

    public String getName() {
        return this.name;
    }

    public ComponentTypeBriefDto getType() {
        return type;
    }

    public void setType(ComponentTypeBriefDto type) {
        this.type = type;
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

    public Boolean getRemoved() {
        return removed;
    }

    public void setRemoved(Boolean removed) {
        this.removed = removed;
    }

    public List<ComponentStoreBriefDto> getStoredComponents() {
        return storedComponents;
    }

    public void setStoredComponents(List<ComponentStoreBriefDto> storedComponents) {
        this.storedComponents = storedComponents;
    }

    public List<ImportBriefDto> getImports() {
        return imports;
    }

    public void setImports(List<ImportBriefDto> imports) {
        this.imports = imports;
    }
}
