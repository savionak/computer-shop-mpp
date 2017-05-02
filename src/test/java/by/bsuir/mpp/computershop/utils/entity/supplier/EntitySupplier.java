package by.bsuir.mpp.computershop.utils.entity.supplier;

import by.bsuir.mpp.computershop.entity.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.io.Serializable;
import java.util.List;

public interface EntitySupplier<E extends BaseEntity<ID>, ID extends Serializable> {
    E getValidEntityWithoutId();

    default E getValidEntityWithId(){
        E result = getValidEntityWithoutId();
        result.setId(getAnyId());
        return result;
    }

    E getInvalidEntity();

    default Page<E> getPage(List<E> content){
        return  new PageImpl<>(content);
    }


    ID getAnyId();

}
