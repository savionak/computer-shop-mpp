package by.bsuir.mpp.computershop.entity;

import by.bsuir.mpp.computershop.entity.dto.AssemblyDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.List;

import static by.bsuir.mpp.computershop.config.ModelMapperConfiguration.modelMapper;
import static by.bsuir.mpp.computershop.utils.ValidationConstants.CANNOT_BE_NEGATIVE_MESSAGE;

@Entity
@Table(name = "assembly")
@DynamicInsert
public class Assembly extends BaseEntity<Long> {
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(name = "cost", nullable = false)
    private Long cost;

    @Min(value = 0, message = CANNOT_BE_NEGATIVE_MESSAGE)
    @Column(name = "count", nullable = false)
    private Long count;

    @OneToMany(mappedBy = "assembly", cascade = CascadeType.ALL)
    private List<AssemblyComponent> components;

    public Order getOrder() {
        return this.order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Long getCost() {
        return this.cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public Long getCount() {
        return this.count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public List<AssemblyComponent> getComponents() {
        return components;
    }

    public void setComponents(List<AssemblyComponent> components) {
        this.components = components;
    }

    @Override
    public AssemblyDto toDto() {
        return modelMapper.map(this, AssemblyDto.class);
    }
}
