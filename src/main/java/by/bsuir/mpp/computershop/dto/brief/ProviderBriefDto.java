package by.bsuir.mpp.computershop.dto.brief;

public class ProviderBriefDto extends BaseBriefDto {

    private String name;

    private String description;

    private Integer importsCount;

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

    public Integer getImportsCount() {
        return importsCount;
    }

    public void setImportsCount(Integer importsCount) {
        this.importsCount = importsCount;
    }
}
