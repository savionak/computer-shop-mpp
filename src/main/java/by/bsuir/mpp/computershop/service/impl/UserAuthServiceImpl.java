package by.bsuir.mpp.computershop.service.impl;

import by.bsuir.mpp.computershop.entity.UserAuth;
import by.bsuir.mpp.computershop.repository.UserAuthRepository;
import by.bsuir.mpp.computershop.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAuthServiceImpl extends AbstractCrudService<UserAuth, Long> implements UserAuthService {

    @Autowired
    public UserAuthServiceImpl(UserAuthRepository userAuthRepository) {
        super(userAuthRepository);
    }

}
