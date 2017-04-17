package by.bsuir.mpp.computershop.repository;

import by.bsuir.mpp.computershop.entity.EmployeeAuth;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeAuthRepository extends CrudRepository<EmployeeAuth, Long> {
    EmployeeAuth findByEmail(String email);
}
