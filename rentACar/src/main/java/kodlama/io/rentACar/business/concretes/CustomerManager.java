package kodlama.io.rentACar.business.concretes;

import kodlama.io.rentACar.business.abstracts.CustomerService;
import kodlama.io.rentACar.business.requests.CreateCustomerRequest;
import kodlama.io.rentACar.business.requests.UpdateCustomerRequest;
import kodlama.io.rentACar.business.responses.GetAllCustomerResponse;
import kodlama.io.rentACar.business.responses.GetByIdCarResponse;
import kodlama.io.rentACar.business.responses.GetByIdCustomerResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.CustomerRepository;
import kodlama.io.rentACar.entities.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Size;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {
    private CustomerRepository customerRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllCustomerResponse> getAll() {
        List<Customer> customers= customerRepository.findAll();
        List<GetAllCustomerResponse> getAllCustomerResponses = customers.stream()
                .map(customer -> this.modelMapperService.forResponse()
                        .map(customer , GetAllCustomerResponse.class)).collect(Collectors.toList());
        return getAllCustomerResponses;
    }

    @Override
    public GetByIdCustomerResponse getById(int id) {
        Customer customer = this.customerRepository.findById(id).orElseThrow();
        GetByIdCustomerResponse getByIdCustomerResponse = this.modelMapperService.forResponse().map(customer , GetByIdCustomerResponse.class);
        return getByIdCustomerResponse;
    }

    @Override
    public void add(CreateCustomerRequest createCustomerRequest) {
        this.modelMapperService.forRequest().map(createCustomerRequest , Customer.class);
    }

    @Override
    public void update(UpdateCustomerRequest updateCustomerRequest) {
        this.modelMapperService.forRequest().map(updateCustomerRequest, Customer.class);
    }

    @Override
    public void delete(int id) {
        this.customerRepository.deleteById(id);
    }
}
