package by.bsuir.mpp.computershop.dto;

public class AssemblyDto extends BaseDto {
    private OrderDto order;

    private Long cost;

    private Long count;

    public OrderDto getOrder() {
        return this.order;
    }

    public void setOrder(OrderDto order) {
        this.order = order;
    }

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
