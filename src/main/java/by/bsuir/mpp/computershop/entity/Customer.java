package by.bsuir.mpp.computershop.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer extends BaseEntity<Long>{
    @Column(name = "name",unique = true, nullable = false)
    private String name;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Order> orders;

    public List<Order> getOrders(){return orders;}
    public void setOrders(List<Order> orders){this.orders = orders;}

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
