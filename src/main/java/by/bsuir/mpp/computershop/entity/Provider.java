package by.bsuir.mpp.computershop.entity;

        import javax.persistence.*;
        import java.util.List;

@Entity
@Table(name = "provider")
public class Provider extends BaseEntity<Long> {

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    @OneToMany(mappedBy = "provider", cascade = CascadeType.ALL)
    private List<Import> imports;

    public List<Import> getImports() {
        return imports;
    }

    public void setImports(List<Import> imports) {
        this.imports = imports;
    }

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
}
