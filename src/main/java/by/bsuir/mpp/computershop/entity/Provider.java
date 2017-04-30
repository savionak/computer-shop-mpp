package by.bsuir.mpp.computershop.entity;

import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "provider")
@DynamicInsert
public class Provider extends BaseEntity<Long> {
    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    @Column(name = "removed", nullable = false)
    private Boolean removed;

    @Column(name = "imports_count", nullable = false)
    private Integer importsCount;

    @OneToMany(mappedBy = "provider", cascade = CascadeType.ALL)
    private List<Import> imports;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean isRemoved() {
        return removed;
    }

    public void setRemoved(Boolean removed) {
        this.removed = removed;
    }

    public Integer getImportsCount() {
        return importsCount;
    }

    public void setImportsCount(Integer importsCount) {
        this.importsCount = importsCount;
    }

    public List<Import> getImports() {
        return imports;
    }

    public void setImports(List<Import> imports) {
        this.imports = imports;
    }
}
