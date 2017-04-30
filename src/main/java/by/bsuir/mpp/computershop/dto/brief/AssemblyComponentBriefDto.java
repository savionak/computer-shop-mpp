package by.bsuir.mpp.computershop.dto.brief;

public class AssemblyComponentBriefDto extends BaseBriefDto<Long> {

    private String modelName;

    private Long price;

    private Long count;

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
