package by.bsuir.mpp.computershop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


@Entity
@Table(name = "`order`")
public class Order extends BaseEntity<Long> {

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @JsonIgnore
    @Transient
    private Long newCustomerId = null;

    @Column(name = "cost", nullable = false)
    private int cost;

    @Column(name = "ord_date", nullable = false)
    private Timestamp ordDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false,
            columnDefinition = "ENUM('IN_PROGRESS', 'READY', 'FINISHED', 'CANCELED')")
    private Status status;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order", cascade = CascadeType.ALL)
    private List<Export> exports;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order", cascade = CascadeType.ALL)
    private List<AssemblyParcel> assemblyParcels;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderComponent> orderComponents;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @JsonProperty("customer_id")
    public Long getCustomerId() {
        return this.customer.getId();
    }

    @JsonProperty("customer_id")
    public void setCustomerId(Long id) {
        this.newCustomerId = id;
    }

    public Long getNewCustomerId() {
        return newCustomerId;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Timestamp getOrdDate() {
        return ordDate;
    }

    public void setOrdDate(Timestamp ordDate) {
        this.ordDate = ordDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Export> getExports() {
        return exports;
    }

    public void setExports(List<Export> exports) {
        this.exports = exports;
    }

    public List<AssemblyParcel> getAssemblyParcels() {
        return assemblyParcels;
    }

    public void setAssemblyParcels(List<AssemblyParcel> assemblyParcels) {
        this.assemblyParcels = assemblyParcels;
    }

    public List<OrderComponent> getOrderComponents() {
        return orderComponents;
    }

    public void setOrderComponents(List<OrderComponent> orderComponents) {
        this.orderComponents = orderComponents;
    }

    public enum Status {
        IN_PROGRESS {
            public String toString() {
                return "собирается";
            }
        },
        READY {
            public String toString() {
                return "готов  сборке";
            }
        },
        FINISHED {
            public String toString() {
                return "завершен";
            }
        },
        CANCELLED {
            public String toString() {
                return "отменен";
            }
        };

        public abstract String toString();
    }
}
