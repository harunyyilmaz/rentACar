package kodlama.io.rentACar.dataAccess.abstracts;

import kodlama.io.rentACar.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;



public interface BrandRepository extends JpaRepository<Brand,Integer>{

    boolean existsByName(String name); // spring Jpa keywords (exists Var mı var olmayı anlatır true ya da false döner.)
}
