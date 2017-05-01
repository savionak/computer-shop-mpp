package by.bsuir.mpp.computershop.utils.entity.supplier;

import by.bsuir.mpp.computershop.entity.BaseEntity;

import java.io.Serializable;

public interface EntitySupplier<E extends BaseEntity<ID>, ID extends Serializable> {
    E getValidEntityWithoutId();

    default E getValidEntityWithId(){
        E result = getValidEntityWithoutId();
        result.setId(getAnyId());
        return result;
    }

    E getInvalidEntity();

    ID getAnyId();

}
