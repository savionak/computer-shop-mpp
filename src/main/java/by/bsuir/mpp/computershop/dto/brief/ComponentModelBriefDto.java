package by.bsuir.mpp.computershop.dto.brief;

public class ComponentModelBriefDto extends BaseBriefDto<Long> {

    private String name;

    private String description;

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
}
