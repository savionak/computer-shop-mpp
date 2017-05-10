package by.bsuir.mpp.computershop.service.impl;

import by.bsuir.mpp.computershop.dto.helper.UpdateUserPassDto;
import by.bsuir.mpp.computershop.entity.UserAuth;
import by.bsuir.mpp.computershop.repository.UserAuthRepository;
import by.bsuir.mpp.computershop.service.UserAuthService;
import by.bsuir.mpp.computershop.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static by.bsuir.mpp.computershop.service.exception.wrapper.RepositoryCallWrapper.wrapRepositoryCall;

@Service
public class UserAuthServiceImpl extends AbstractSoftDeleteService<UserAuth, Long> implements UserAuthService {

    private final UserAuthRepository userRepository;

    @Autowired
    public UserAuthServiceImpl(UserAuthRepository userAuthRepository) {
        super(userAuthRepository);
        this.userRepository = userAuthRepository;
    }

    @Override
    public void updatePasswordHash(UpdateUserPassDto passDto) throws ServiceException {
        wrapRepositoryCall(() -> userRepository.updatePasswordHash(passDto.getUserId(), passDto.getNewHash()));
    }

    @Override
    public void dropUser(Long id) throws ServiceException {
        wrapRepositoryCall(() -> userRepository.drop(id));
    }

    @Override
    protected void updateOnUpdate(UserAuth entity) throws ServiceException {
        UserAuth template = wrapRepositoryCall(() -> userRepository.findOne(entity.getId()));
        entity.setRemoved(template.getRemoved());
        entity.setBlocked(template.isBlocked());
    }
}
