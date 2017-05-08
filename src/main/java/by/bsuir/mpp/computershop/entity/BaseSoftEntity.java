package by.bsuir.mpp.computershop.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public abstract class BaseSoftEntity<ID extends Serializable> extends BaseEntity<ID> {

    @Column(name = "removed", nullable = false)
    protected Boolean removed;

    public Boolean getRemoved() {
        return removed;
    }

    public void setRemoved(Boolean removed) {
        this.removed = removed;
    }
}
