package by.bsuir.mpp.computershop.repository;

import by.bsuir.mpp.computershop.entity.BaseSoftEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

@NoRepositoryBean
public interface SoftDeleteRepository<E extends BaseSoftEntity<ID>, ID extends Serializable>
        extends PagingAndSortingRepository<E, ID> {

    @Override
    void delete(ID id);

    void restore(ID id);

    Page<E> findAllByRemovedIsFalse(Pageable pageable);

    Page<E> findAllByRemovedIsTrue(Pageable pageable);
}
