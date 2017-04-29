package by.bsuir.mpp.computershop.dto.brief;

import by.bsuir.mpp.computershop.entity.Order.Status;

import java.sql.Timestamp;

public class OrderDto extends BaseBriefDto {
    private CustomerDto customer;

    private Long cost;

    private Timestamp orderDate;

    private Status status;

    private Boolean canceled;

    public CustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDto customer) {
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

    public Boolean isCanceled() {
        return canceled;
    }

    public void setCanceled(Boolean canceled) {
        this.canceled = canceled;
    }
}
