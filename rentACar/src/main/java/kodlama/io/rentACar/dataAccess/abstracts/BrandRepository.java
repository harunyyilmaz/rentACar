package kodlama.io.rentACar.dataAccess.abstracts;

import kodlama.io.rentACar.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;



public interface BrandRepository extends JpaRepository<Brand,Integer>{
    //List<Brand> getAll(); spring Jpa bize artık her şeyi getiriyor gerek kalmıyor. "ARTIK İNMEMORYBRANDREPOSİTORY SİLİNEBİLİR."
}
