package by.bsuir.mpp.computershop.dto.brief;

public class ComponentModelBriefDto extends BaseBriefDto<Long> {

    private Long typeId;

    private Long typeName;

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

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Long getTypeName() {
        return typeName;
    }

    public void setTypeName(Long typeName) {
        this.typeName = typeName;
    }
}
