package by.bsuir.mpp.computershop.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "component_type")
public class ComponentType implements Serializable {
    public static final long serialVersionUID = 8547556L;

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    @Column(columnDefinition = "text")
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName(){
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
