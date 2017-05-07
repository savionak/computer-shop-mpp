package by.bsuir.mpp.computershop.repository;

import by.bsuir.mpp.computershop.entity.UserAuth;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserAuthRepository extends PagingAndSortingRepository<UserAuth, Long> {
    UserAuth findByEmail(String email);

    @Transactional
    @Modifying
    @Query(value = "CALL update_pass(:id, :new_hash)", nativeQuery = true)
    void updatePasswordHash(@Param("id") Long id, @Param("new_hash") String newPassHash);
}
