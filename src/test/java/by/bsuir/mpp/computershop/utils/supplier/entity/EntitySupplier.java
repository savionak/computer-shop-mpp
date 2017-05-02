package by.bsuir.mpp.computershop.utils.supplier.entity;

import by.bsuir.mpp.computershop.entity.BaseEntity;
import by.bsuir.mpp.computershop.utils.TestHelper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public interface EntitySupplier<E extends BaseEntity<ID>, ID extends Serializable> {

    int DEFAULT_PAGE_SIZE = 20;

    E getValidEntityWithoutId();

    default E getValidEntityWithId() {
        E result = getValidEntityWithoutId();
        result.setId(getAnyId());
        return result;
    }

    E getInvalidEntity();

    default Page<E> getPage(List<E> content) {
        return new PageImpl<>(content);
    }

    default List<E> getValidEntitiesList() {
        List<E> result = new ArrayList<>();
        int size = TestHelper.nextInt(DEFAULT_PAGE_SIZE);
        for (int i = 0; i < size; ++i) {
            result.add(getValidEntityWithId());
        }
        return result;
    }

    ID getAnyId();
}
