package kodlama.io.rentACar.dataAccess.abstracts;

import kodlama.io.rentACar.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    boolean existsByNationalIdentityNumber(String nationalIdentityNumber);
}
