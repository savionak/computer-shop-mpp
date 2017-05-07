package by.bsuir.mpp.computershop.service.impl;

import by.bsuir.mpp.computershop.dto.full.UpdatePassDto;
import by.bsuir.mpp.computershop.entity.UserAuth;
import by.bsuir.mpp.computershop.repository.UserAuthRepository;
import by.bsuir.mpp.computershop.service.UserAuthService;
import by.bsuir.mpp.computershop.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static by.bsuir.mpp.computershop.service.exception.wrapper.RepositoryCallWrapper.wrapRepositoryCall;

@Service
public class UserAuthServiceImpl extends AbstractCrudService<UserAuth, Long> implements UserAuthService {

    private final UserAuthRepository userRepository;

    @Autowired
    public UserAuthServiceImpl(UserAuthRepository userAuthRepository) {
        super(userAuthRepository);
        this.userRepository = userAuthRepository;
    }

    @Override
    public void updatePasswordHash(UpdatePassDto passDto) throws ServiceException{
        wrapRepositoryCall(() -> userRepository.updatePasswordHash(passDto.getUserId(), passDto.getNewHash()));
    }

    @Override
    protected boolean validateAdd(UserAuth entity) {
        return entity.getPassHash() != null;
    }
}
