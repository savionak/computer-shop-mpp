package by.bsuir.mpp.computershop.dto.brief;

public class AssemblyComponentDto extends BaseBriefDto {
    private Long assemblyId;

    private Long componentId;

    private Long count;

    public Long getAssemblyId() {
        return assemblyId;
    }

    public void setAssemblyId(Long assemblyId) {
        this.assemblyId = assemblyId;
    }

    public Long getComponentId() {
        return componentId;
    }

    public void setComponentId(Long componentId) {
        this.componentId = componentId;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
