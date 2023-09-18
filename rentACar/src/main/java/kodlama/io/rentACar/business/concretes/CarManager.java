package kodlama.io.rentACar.business.concretes;

import kodlama.io.rentACar.business.abstracts.CarService;
import kodlama.io.rentACar.business.business.rules.CarBusinessRules;
import kodlama.io.rentACar.business.business.rules.ModelBusinessRules;
import kodlama.io.rentACar.business.requests.CreateCarRequest;
import kodlama.io.rentACar.business.requests.UpdateCarRequest;
import kodlama.io.rentACar.business.responses.GetAllCarResponse;
import kodlama.io.rentACar.business.responses.GetByIdCarResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.CarRepository;
import kodlama.io.rentACar.entities.Car;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarManager implements CarService {
    private CarRepository carRepository;
    private ModelMapperService modelMapperService;
    private CarBusinessRules carBusinessRules;
    @Override
    public List<GetAllCarResponse> getAll() {
        List<Car> cars = this.carRepository.findAll();
        List<GetAllCarResponse> carResponses = cars.stream()
                .map(car -> this.modelMapperService.forResponse()
                        .map(car,GetAllCarResponse.class)).collect(Collectors.toList());

        return carResponses;
    }

    @Override
    public GetByIdCarResponse getById(int id) {
        Car car = this.carRepository.findById(id).orElseThrow();
        GetByIdCarResponse carResponse = this.modelMapperService.forResponse().map(car,GetByIdCarResponse.class);
        return carResponse;
    }


    @Override
    public void add(CreateCarRequest createCarRequest) {

        this.carBusinessRules.checkIfCarNameExists(createCarRequest.getPlate());

        Car car=this.modelMapperService.forRequest().map(createCarRequest,Car.class);
        this.carRepository.save(car);

    }

    @Override
    public void update(UpdateCarRequest updateCarRequest) {
        Car car= this.modelMapperService.forRequest().map(updateCarRequest,Car.class);
        this.carRepository.save(car);
    }

    @Override
    public void delete(int id) {
        this.carRepository.deleteById(id);

    }
}
