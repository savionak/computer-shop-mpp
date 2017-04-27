package by.bsuir.mpp.computershop.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "assembly_parcel")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "remove_parcel_tasks",
                procedureName = "remove_parcel_tasks",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "parcel_id", type = Long.class)
                })
})
public class AssemblyParcel extends BaseEntity<Long> implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(name = "cost", nullable = false)
    private long cost;

    @Column(name = "count", nullable = false)
    private long count;

    @Column(name = "free_count", nullable = false)
    private long freeCount;

    @Column(name = "done_count", nullable = false, columnDefinition = "int default 0")
    private long doneCount;

    @Column(name = "canceled", nullable = false)
    private boolean canceled = false;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parcel", cascade = CascadeType.ALL)
    private List<AssemblyComponent> components;

    public Order getOrder() {
        return this.order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public long getCost() {
        return this.cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    public long getCount() {
        return this.count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public long getDoneCount() {
        return this.doneCount;
    }

    public void setDoneCount(long doneCount) {
        this.doneCount = doneCount;
    }

    public List<AssemblyComponent> getComponents() {
        return components;
    }

    public void setComponents(List<AssemblyComponent> components) {
        this.components = components;
    }

    public boolean isCanceled() {
        return canceled;
    }

    public void setCanceled(boolean canceled) {
        this.canceled = canceled;
    }

    public long getFreeCount() {
        return freeCount;
    }

    public void setFreeCount(long freeCount) {
        this.freeCount = freeCount;
    }
}
