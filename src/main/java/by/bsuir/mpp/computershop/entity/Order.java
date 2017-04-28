package by.bsuir.mpp.computershop.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.List;

import static by.bsuir.mpp.computershop.utils.ValidationConstants.CANNOT_BE_NULL_MESSAGE;

@Entity
@Table(name = "`order`")
public class Order extends BaseEntity<Long> {
    @NotNull(message = CANNOT_BE_NULL_MESSAGE)
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(name = "cost", nullable = false)
    private long cost;

    @NotNull(message = CANNOT_BE_NULL_MESSAGE)
    @Column(name = "order_date", nullable = false)
    private Timestamp orderDate;

    @NotNull(message = CANNOT_BE_NULL_MESSAGE)
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false,
            columnDefinition = Status.TYPE_DEFINITION)
    private Status status;

    @Column(name = "canceled", nullable = false)
    private boolean canceled = false;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
    private List<Export> exports;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Assembly> assemblies;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
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

    public boolean isCanceled() {
        return canceled;
    }

    public void setCanceled(boolean canceled) {
        this.canceled = canceled;
    }

    public List<Export> getExports() {
        return exports;
    }

    public void setExports(List<Export> exports) {
        this.exports = exports;
    }

    public List<Assembly> getAssemblies() {
        return assemblies;
    }

    public void setAssemblies(List<Assembly> assemblyParcels) {
        this.assemblies = assemblyParcels;
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

        public static final String TYPE_DEFINITION = "ENUM ('IN_PROGRESS', 'FINISHED')";
        public abstract String toString();
    }
}
