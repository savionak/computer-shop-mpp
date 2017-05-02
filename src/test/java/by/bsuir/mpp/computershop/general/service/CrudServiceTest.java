package by.bsuir.mpp.computershop.general.service;

import by.bsuir.mpp.computershop.entity.BaseEntity;
import by.bsuir.mpp.computershop.service.CrudService;
import by.bsuir.mpp.computershop.service.exception.BadEntityException;
import by.bsuir.mpp.computershop.service.exception.EntityNotFoundException;
import by.bsuir.mpp.computershop.service.exception.ServiceException;
import by.bsuir.mpp.computershop.utils.supplier.entity.EntitySupplier;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Matchers;
import org.mockito.MockitoAnnotations;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.QueryTimeoutException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public abstract class CrudServiceTest<E extends BaseEntity<ID>, ID extends Serializable> {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void initTests() {
        MockitoAnnotations.initMocks(this);
    }

    protected abstract CrudService<E, ID> getCrudService();

    protected abstract PagingAndSortingRepository<E, ID> getCrudRepository();

    protected abstract EntitySupplier<E, ID> getEntitySupplier();

    @Test
    public void findExistingEntityTest() throws Exception {
        E expectedEntity = getEntitySupplier().getValidEntityWithId();
        ID id = expectedEntity.getId();
        when(getCrudRepository().findOne(id)).thenReturn(expectedEntity);

        E actualResult = getCrudService().getOne(id);

        verify(getCrudRepository(), times(1)).findOne(id);
        Assert.assertEquals(expectedEntity, actualResult);
    }

    @Test
    public void findAllEntitiesPageTest() throws Exception {
        List<E> content = getEntitySupplier().getValidEntitiesList();

        Page<E> databasePage = getEntitySupplier().getPage(content);
        Pageable pageable = new PageRequest(0, Integer.MAX_VALUE);
        when(getCrudRepository().findAll(pageable)).thenReturn(databasePage);

        Page<E> result = getCrudService().getAll(pageable);

        verify(getCrudRepository(), times(1)).findAll(Matchers.<Pageable>any());
        Assert.assertEquals(content.size(), result.getTotalElements());
    }

    @Test
    public void findAllEntitiesEmptyTest() throws Exception {
        Page<E> databasePage = getEntitySupplier().getPage(new ArrayList<>());

        Pageable pageable = new PageRequest(0, 10);
        when(getCrudRepository().findAll(pageable)).thenReturn(databasePage);

        Page<E> result = getCrudService().getAll(pageable);

        verify(getCrudRepository(), times(1)).findAll(Matchers.<Pageable>any());
        Assert.assertEquals(0, result.getTotalElements());
    }

    @Test(expected = EntityNotFoundException.class)
    public void findNonExistingEntityTest() throws Exception {
        ID id = getEntitySupplier().getAnyId();
        when(getCrudRepository().findOne(id)).thenReturn(null);
        getCrudService().getOne(id);
    }

    @Test(expected = BadEntityException.class)
    public void updateEntityExceptionTest() throws Exception {
        E entity = getEntitySupplier().getValidEntityWithId();
        when(getCrudRepository().save(Matchers.<E>any())).thenThrow(new DataIntegrityViolationException(""));
        when(getCrudRepository().exists(any())).thenReturn(true);

        getCrudService().update(entity);
    }

    @Test(expected = ServiceException.class)
    public void updateEntityDataAccessExceptionTest() throws Exception {
        E entity = getEntitySupplier().getValidEntityWithId();
        when(getCrudRepository().save(Matchers.<E>any())).thenThrow(new QueryTimeoutException(""));
        when(getCrudRepository().exists(any())).thenReturn(true);

        try {
            getCrudService().update(entity);
        } catch (ServiceException e) {
            Assert.assertFalse(e instanceof BadEntityException);
            throw e;
        }
    }

    @Test(expected = EntityNotFoundException.class)
    public void updateNonExistingEntityTest() throws Exception {
        E entity = getEntitySupplier().getValidEntityWithoutId();
        ID parameterId = getEntitySupplier().getAnyId();
        when(getCrudRepository().exists(parameterId)).thenReturn(false);
        when(getCrudRepository().findOne(parameterId)).thenReturn(null);

        getCrudService().update(entity);
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
