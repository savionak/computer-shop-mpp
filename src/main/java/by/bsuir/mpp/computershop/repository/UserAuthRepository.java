package by.bsuir.mpp.computershop.repository;

import by.bsuir.mpp.computershop.entity.UserAuth;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserAuthRepository extends PagingAndSortingRepository<UserAuth, Long> {
    UserAuth findByEmail(String email);
}
