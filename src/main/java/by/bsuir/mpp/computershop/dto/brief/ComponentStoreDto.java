package by.bsuir.mpp.computershop.dto.brief;

public class ComponentStoreDto extends BaseBriefDto {
    private Long modelId;

    private Long price;

    private Long count;

    public Long getModelId() {
        return modelId;
    }

    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }

    public Long getPrice() {
        return this.price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getCount() {
        return this.count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
