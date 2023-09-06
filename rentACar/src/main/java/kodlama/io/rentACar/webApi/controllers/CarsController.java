package kodlama.io.rentACar.webApi.controllers;

import kodlama.io.rentACar.business.abstracts.CarService;

import kodlama.io.rentACar.business.requests.CreateCarRequest;
import kodlama.io.rentACar.business.requests.UpdateCarRequest;
import kodlama.io.rentACar.business.responses.GetAllCarResponse;
import kodlama.io.rentACar.business.responses.GetByIdCarResponse;
import kodlama.io.rentACar.entities.Car;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/cars")
public class CarsController {
    private CarService carService;

    @GetMapping
    public List<GetAllCarResponse>  getAll(){
        return carService.getAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED) // sadece 201 döndürsün diye eklenen bir şeydir.
    public void add(@RequestBody @Valid CreateCarRequest createCarRequest){
        this.carService.add(createCarRequest);
    }
    @GetMapping("/{id}")
    public GetByIdCarResponse getById(@PathVariable int id){
        return this.carService.getById(id);
    }

    @PutMapping
    public void update(@RequestBody UpdateCarRequest updateCarRequest){
        this.carService.update(updateCarRequest);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.carService.delete(id);
    }
}
