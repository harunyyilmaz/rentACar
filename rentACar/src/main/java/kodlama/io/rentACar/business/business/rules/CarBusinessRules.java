package kodlama.io.rentACar.business.business.rules;

import kodlama.io.rentACar.core.utilities.exceptions.BusinessException;
import kodlama.io.rentACar.dataAccess.abstracts.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CarBusinessRules {
    private CarRepository carRepository;
    public void checkIfCarNameExists(String plate){
        if (this.carRepository.existsByPlate(plate)){
            throw new BusinessException("Car name already exists.");
        }
    }
}
