package by.bsuir.mpp.computershop.general.service;

import by.bsuir.mpp.computershop.entity.BaseSoftEntity;
import by.bsuir.mpp.computershop.repository.SoftDeleteRepository;
import by.bsuir.mpp.computershop.service.SoftDeleteService;
import by.bsuir.mpp.computershop.service.exception.EntityNotFoundException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Matchers;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public abstract class SoftDeleteServiceTest<E extends BaseSoftEntity<ID>, ID extends Serializable>
        extends CrudServiceTest<E, ID> {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void initTests() {
        MockitoAnnotations.initMocks(this);
    }

    @Override
    protected abstract SoftDeleteService<E, ID> getCrudService();

    @Override
    protected abstract SoftDeleteRepository<E, ID> getCrudRepository();

    @Test
    public void findAllEntitiesPageTest() throws Exception {
        List<E> content = getEntitySupplier().getValidEntitiesList();

        Page<E> databasePage = getEntitySupplier().getPage(content);
        Pageable pageable = new PageRequest(0, Integer.MAX_VALUE);
        when(getCrudRepository().findAllByRemovedIsFalse(pageable)).thenReturn(databasePage);

        Page<E> result = getCrudService().getAll(pageable);

        verify(getCrudRepository(), times(1)).findAllByRemovedIsFalse(Matchers.<Pageable>any());
        Assert.assertEquals(content.size(), result.getTotalElements());
    }

    @Test
    public void findAllEntitiesEmptyTest() throws Exception {
        Page<E> databasePage = getEntitySupplier().getPage(new ArrayList<>());

        Pageable pageable = new PageRequest(0, 10);
        when(getCrudRepository().findAllByRemovedIsFalse(pageable)).thenReturn(databasePage);

        Page<E> result = getCrudService().getAll(pageable);

        verify(getCrudRepository(), times(1)).findAllByRemovedIsFalse(Matchers.<Pageable>any());
        Assert.assertEquals(0, result.getTotalElements());
    }

    @Test
    public void deleteExistingEntityTest() throws Exception {
        when(getCrudRepository().exists(Matchers.any())).thenReturn(true);
        getCrudService().delete(getEntitySupplier().getAnyId());
    }

    @Test(expected = EntityNotFoundException.class)
    public void deleteNonExistingEntityTest() throws Exception {
        when(getCrudRepository().exists(Matchers.any())).thenReturn(false);
        getCrudService().delete(getEntitySupplier().getAnyId());
    }
}
