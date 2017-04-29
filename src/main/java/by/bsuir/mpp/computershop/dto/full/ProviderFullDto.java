package by.bsuir.mpp.computershop.dto.full;

import by.bsuir.mpp.computershop.dto.brief.BaseBriefDto;
import by.bsuir.mpp.computershop.dto.brief.ImportBriefDto;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

import static by.bsuir.mpp.computershop.utils.ValidationConstants.*;

public class ProviderFullDto extends BaseBriefDto {

    @NotNull(message = CANNOT_BE_NULL_MESSAGE)
    @Pattern(regexp = NON_EMPTY_STRING_REGEX, message = CANNOT_BE_EMPTY_MESSAGE)
    private String name;

    private String description;

    private Boolean removed;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer importsCount;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<ImportBriefDto> imports;

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

    public Integer getImportsCount() {
        return importsCount;
    }

    public void setImportsCount(Integer importsCount) {
        this.importsCount = importsCount;
    }

    public List<ImportBriefDto> getImports() {
        return imports;
    }

    public void setImports(List<ImportBriefDto> imports) {
        this.imports = imports;
    }
}