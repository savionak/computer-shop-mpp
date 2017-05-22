package by.bsuir.mpp.computershop.document.model.mapper;

import by.bsuir.mpp.computershop.entity.BaseEntity;

import java.io.Serializable;
import java.util.List;

public interface EntityToRowMapper<ID extends Serializable, E extends BaseEntity<ID>> {
    List<String> toRow(E entity);
}
