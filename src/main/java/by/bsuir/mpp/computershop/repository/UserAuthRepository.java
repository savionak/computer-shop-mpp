package by.bsuir.mpp.computershop.repository;

import by.bsuir.mpp.computershop.entity.UserAuth;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserAuthRepository extends SoftDeleteRepository<UserAuth, Long> {

    UserAuth findByEmail(String email);

    @Override
    @Transactional
    @Modifying
    @Query(value = "CALL remove_user(:id);", nativeQuery = true)
    void delete(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query(value = "CALL restore_user(:id);", nativeQuery = true)
    void restore(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query(value = "CALL drop_user(:id);", nativeQuery = true)
    void drop(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query(value = "CALL update_pass(:id, :new_hash)", nativeQuery = true)
    void updatePasswordHash(@Param("id") Long id, @Param("new_hash") String newPassHash);
}
