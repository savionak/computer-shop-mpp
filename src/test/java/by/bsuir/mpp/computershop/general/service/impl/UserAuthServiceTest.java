package by.bsuir.mpp.computershop.general.service.impl;

import by.bsuir.mpp.computershop.entity.UserAuth;
import by.bsuir.mpp.computershop.general.service.CrudServiceTest;
import by.bsuir.mpp.computershop.repository.UserAuthRepository;
import by.bsuir.mpp.computershop.service.CrudService;
import by.bsuir.mpp.computershop.service.UserAuthService;
import by.bsuir.mpp.computershop.service.impl.UserAuthServiceImpl;
import by.bsuir.mpp.computershop.utils.entity.supplier.EntitySupplier;
import by.bsuir.mpp.computershop.utils.entity.supplier.impl.UserAuthEntitySupplier;
import org.mockito.Mockito;
import org.springframework.data.repository.PagingAndSortingRepository;


public class UserAuthServiceTest extends CrudServiceTest<UserAuth, Long>{

    private UserAuthService userAuthService;
    private UserAuthRepository userAuthRepository;
    private UserAuthEntitySupplier userAuthEntitySupplier;

    public UserAuthServiceTest(){
        userAuthRepository= Mockito.mock(UserAuthRepository.class);
        userAuthService = new UserAuthServiceImpl(userAuthRepository) ;
        userAuthEntitySupplier =  new UserAuthEntitySupplier();
    }

    @Override
    protected CrudService<UserAuth, Long> getCrudService() {
        return userAuthService;
    }

    @Override
    protected PagingAndSortingRepository<UserAuth, Long> getCrudRepository() {
        return userAuthRepository;
    }

    @Override
    protected EntitySupplier<UserAuth, Long> getEntitySupplier() {
        return userAuthEntitySupplier;
    }
}
