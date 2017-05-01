package by.bsuir.mpp.computershop.general.service;

import by.bsuir.mpp.computershop.entity.BaseEntity;
import by.bsuir.mpp.computershop.service.CrudService;
import by.bsuir.mpp.computershop.service.exception.EntityNotFoundException;
import by.bsuir.mpp.computershop.service.exception.ServiceException;
import by.bsuir.mpp.computershop.utils.entity.supplier.EntitySupplier;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Matchers;
import org.mockito.MockitoAnnotations;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

import static org.mockito.Mockito.*;

public abstract class CrudServiceTest<E extends BaseEntity<ID>, ID extends Serializable> {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Captor
    protected ArgumentCaptor<E> captor;

    @Before
    public void initTests() {
        MockitoAnnotations.initMocks(this);
    }

    protected abstract CrudService<E, ID> getCrudService();

    protected abstract CrudRepository<E, ID> getCrudRepository();

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


    @Test(expected = EntityNotFoundException.class)
    public void findNotExistingEntityTest() throws Exception {
        ID id = getEntitySupplier().getAnyId();
        when(getCrudRepository().findOne(id)).thenReturn(null);
        E entity = getCrudService().getOne(id);
    }


    @Test(expected = ServiceException.class)
    public void updateEntityExceptionTest() throws Exception {
        E entity = getEntitySupplier().getValidEntityWithoutId();
        when(getCrudRepository().save(Matchers.<E>any())).thenThrow(new DataIntegrityViolationException(""));
        when(getCrudRepository().exists(any())).thenReturn(true);

        getCrudService().update(entity);
    }

    @Test(expected = EntityNotFoundException.class)
    public void updateNotExistingEntityTest() throws Exception {
        E entity = getEntitySupplier().getValidEntityWithoutId();
        ID parameterId = getEntitySupplier().getAnyId();
        when(getCrudRepository().exists(parameterId)).thenReturn(false);
        when(getCrudRepository().findOne(parameterId)).thenReturn(null);

        E actualResult = getCrudService().update(entity);
    }

    @Test(expected = EntityNotFoundException.class)
    public void deleteExistingEntityTest() throws Exception {
        getCrudService().delete(getEntitySupplier().getAnyId());
    }

    @Test(expected = EntityNotFoundException.class)
    public void deleteNotExistingEntityTest() throws Exception {
        doThrow(new EmptyResultDataAccessException(1)).when(getCrudRepository()).delete(Matchers.<ID>any());

        getCrudService().delete(getEntitySupplier().getAnyId());
    }
}
