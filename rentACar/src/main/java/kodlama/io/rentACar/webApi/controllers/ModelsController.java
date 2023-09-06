package kodlama.io.rentACar.webApi.controllers;

import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.business.requests.CreateModelRequest;
import kodlama.io.rentACar.business.requests.UpdateModelRequest;
import kodlama.io.rentACar.business.responses.GetAllModelsResponse;
import kodlama.io.rentACar.business.responses.GetByIdModelsResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/models")
@AllArgsConstructor
public class ModelsController {
    private ModelService modelService;

    @GetMapping()
    public List<GetAllModelsResponse> getAll(){
        return this.modelService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdModelsResponse getById(@PathVariable int id){
        return this.modelService.getById(id);
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED) // sadece 201 döndürsün diye eklenen bir şeydir.
    public void add(@RequestBody @Valid CreateModelRequest createModelRequest){
        this.modelService.add(createModelRequest);
    }

    @PutMapping()
    public void update(@RequestBody UpdateModelRequest updateModelRequest){
        this.modelService.update(updateModelRequest);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.modelService.deleteId(id);
    }
}
