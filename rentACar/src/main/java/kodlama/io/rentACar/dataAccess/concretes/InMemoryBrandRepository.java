package kodlama.io.rentACar.dataAccess.concretes;

import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.entities.concretes.Brand;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;
@Repository // bu sınıf bir data access nesnesidir.
public class InMemoryBrandRepository implements BrandRepository {

    List<Brand> brands;

    public InMemoryBrandRepository() {
        brands = new ArrayList<Brand>();
        brands.add(new Brand(1,"bmw"));
        brands.add(new Brand(2,"audi"));
        brands.add(new Brand(3,"mercedes"));
        brands.add(new Brand(4,"fiat"));
        brands.add(new Brand(5,"renault"));
    }

    @Override
    public List<Brand> getAll() {

        return brands;
    }
}
