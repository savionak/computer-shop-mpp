package by.bsuir.mpp.computershop.dto.brief;

import by.bsuir.mpp.computershop.entity.Order.Status;

import java.sql.Timestamp;

public class OrderBriefDto extends BaseBriefDto {

    private CustomerBriefDto customer;

    private Long cost;

    private Timestamp orderDate;

    private Status status;

    public CustomerBriefDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerBriefDto customer) {
        this.customer = customer;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp ordDate) {
        this.orderDate = ordDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
