package by.bsuir.mpp.computershop.service.impl;

import by.bsuir.mpp.computershop.dto.full.UpdatePassDto;
import by.bsuir.mpp.computershop.entity.UserAuth;
import by.bsuir.mpp.computershop.repository.UserAuthRepository;
import by.bsuir.mpp.computershop.service.UserAuthService;
import by.bsuir.mpp.computershop.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public void updatePasswordHash(UpdatePassDto passDto) throws ServiceException {
        wrapRepositoryCall(() -> userRepository.updatePasswordHash(passDto.getUserId(), passDto.getNewHash()));
    }

    @Override
    public Page<UserAuth> getAll(Pageable pageable) throws ServiceException {
        return wrapRepositoryCall(() -> userRepository.findAllByRemovedIsFalse(pageable));
    }

    @Override
    public Page<UserAuth> getRemoved(Pageable pageable) throws ServiceException {
        return wrapRepositoryCall(() -> userRepository.findAllByRemovedIsTrue(pageable));
    }

    @Override
    public void restore(Long id) throws ServiceException {
        wrapRepositoryCall(() -> userRepository.restore(id));
    }

    @Override
    public void dropUser(Long id) throws ServiceException {
        wrapRepositoryCall(() -> userRepository.drop(id));
    }
}
