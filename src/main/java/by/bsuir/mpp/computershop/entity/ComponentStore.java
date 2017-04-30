package by.bsuir.mpp.computershop.entity;

import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "component_store")
@DynamicInsert
public class ComponentStore extends BaseEntity<Long> {

    @ManyToOne
    @JoinColumn(name = "model_id", nullable = false)
    private ComponentModel model;

    @Column(name = "price")
    private Long price;

    @Column(name = "count")
    private Long count;

    @OneToMany(mappedBy = "stored")
    private List<Import> imports;

    public ComponentModel getModel() {
        return this.model;
    }

    public void setModel(ComponentModel model) {
        this.model = model;
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

    public List<Import> getImports() {
        return imports;
    }

    public void setImports(List<Import> imports) {
        this.imports = imports;
    }
}
