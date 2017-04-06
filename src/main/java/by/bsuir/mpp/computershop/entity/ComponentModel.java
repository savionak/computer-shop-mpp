package by.bsuir.mpp.computershop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "component_model")
public class ComponentModel extends BaseEntity<Long>{

    @Column(unique = true, nullable = false)
    private int type_id;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "text")
    private String description;


    public int getType_id(){
        return this.type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
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
