package by.bsuir.mpp.computershop.repository;

import by.bsuir.mpp.computershop.entity.UserAuth;
import org.springframework.data.repository.CrudRepository;

public interface UserAuthRepository extends CrudRepository<UserAuth, Long> {
    UserAuth findByEmail(String email);
}
