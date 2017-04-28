package by.bsuir.mpp.computershop.dto;

public class ComponentTypeDto extends BaseDto {
    private String name;
    
    private String description;
    
    private Boolean removed;

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
