package by.bsuir.mpp.computershop.dto.brief;

public class AssemblyBriefDto extends BaseBriefDto<Long> {

    private Long cost;

    private Long count;

    public Long getCost() {
        return this.cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public Long getCount() {
        return this.count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
