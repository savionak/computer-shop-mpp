package by.bsuir.mpp.computershop.general.service.impl;

import by.bsuir.mpp.computershop.entity.UserAuth;
import by.bsuir.mpp.computershop.general.service.SoftDeleteServiceTest;
import by.bsuir.mpp.computershop.repository.SoftDeleteRepository;
import by.bsuir.mpp.computershop.repository.UserAuthRepository;
import by.bsuir.mpp.computershop.service.SoftDeleteService;
import by.bsuir.mpp.computershop.service.UserAuthService;
import by.bsuir.mpp.computershop.service.impl.UserAuthServiceImpl;
import by.bsuir.mpp.computershop.utils.supplier.entity.EntitySupplier;
import by.bsuir.mpp.computershop.utils.supplier.entity.impl.UserAuthEntitySupplier;
import org.mockito.Mockito;


public class UserAuthServiceTest extends SoftDeleteServiceTest<UserAuth, Long> {

    private UserAuthService userAuthService;
    private UserAuthRepository userAuthRepository;
    private UserAuthEntitySupplier userAuthEntitySupplier;

    public UserAuthServiceTest() {
        userAuthRepository = Mockito.mock(UserAuthRepository.class);
        userAuthService = new UserAuthServiceImpl(userAuthRepository);
        userAuthEntitySupplier = new UserAuthEntitySupplier();
    }

    @Override
    protected SoftDeleteService<UserAuth, Long> getCrudService() {
        return userAuthService;
    }

    @Override
    protected SoftDeleteRepository<UserAuth, Long> getCrudRepository() {
        return userAuthRepository;
    }

    @Override
    protected EntitySupplier<UserAuth, Long> getEntitySupplier() {
        return userAuthEntitySupplier;
    }
}
