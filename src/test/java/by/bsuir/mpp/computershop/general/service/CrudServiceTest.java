package by.bsuir.mpp.computershop.general.service;

import by.bsuir.mpp.computershop.entity.BaseEntity;
import by.bsuir.mpp.computershop.service.CrudService;
import by.bsuir.mpp.computershop.service.exception.EntityNotFoundException;
import by.bsuir.mpp.computershop.utils.entity.supplier.EntitySupplier;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.MockitoAnnotations;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

import static org.mockito.Mockito.*;

public abstract class CrudServiceTest<E extends BaseEntity<ID>, ID extends Serializable> {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

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

}
