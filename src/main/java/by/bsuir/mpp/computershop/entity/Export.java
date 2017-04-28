package by.bsuir.mpp.computershop.entity;

import by.bsuir.mpp.computershop.dto.ExportDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.sql.Timestamp;

import static by.bsuir.mpp.computershop.config.ModelMapperConfiguration.mapper;

@Entity
@Table(name = "export")
@DynamicInsert
public class Export extends BaseEntity<Long> {
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @Column(name = "export_date", nullable = false)
    private Timestamp exportDate;

    public Order getOrder() {
        return this.order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Timestamp getExportDate() {
        return exportDate;
    }

    public void setExportDate(Timestamp expDate) {
        this.exportDate = expDate;
    }

    @Override
    public ExportDto toDto() {
        return mapper.map(this, ExportDto.class);
    }
}
