package by.bsuir.mpp.computershop.service;

import by.bsuir.mpp.computershop.dto.full.UpdatePassDto;
import by.bsuir.mpp.computershop.entity.UserAuth;
import by.bsuir.mpp.computershop.service.exception.ServiceException;

public interface UserAuthService extends WithRestoreService<UserAuth, Long> {

    void updatePasswordHash(UpdatePassDto passDto) throws ServiceException;

    void dropUser(Long id) throws ServiceException;
}
