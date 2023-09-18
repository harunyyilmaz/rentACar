package kodlama.io.rentACar.business.abstracts;

import kodlama.io.rentACar.business.requests.CreateCustomerRequest;
import kodlama.io.rentACar.business.requests.UpdateCustomerRequest;
import kodlama.io.rentACar.business.responses.GetAllCustomerResponse;
import kodlama.io.rentACar.business.responses.GetByIdCarResponse;
import kodlama.io.rentACar.business.responses.GetByIdCustomerResponse;

import java.util.List;

public interface CustomerService {

    List<GetAllCustomerResponse> getAll();

    GetByIdCustomerResponse getById(int id);

    void add(CreateCustomerRequest createCustomerRequest);

    void update(UpdateCustomerRequest updateCustomerRequest);

    void delete(int id);

}
