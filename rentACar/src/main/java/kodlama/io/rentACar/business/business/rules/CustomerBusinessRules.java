package kodlama.io.rentACar.business.business.rules;

import kodlama.io.rentACar.core.utilities.exceptions.BusinessException;
import kodlama.io.rentACar.dataAccess.abstracts.CustomerRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CustomerBusinessRules {
    private CustomerRepository customerRepository;
    public void checkIfCustomerNameExists(String nationalIdentityNumber){
        if(this.customerRepository.existsByNationalIdentityNumber(nationalIdentityNumber)){
            throw new BusinessException("National Identity Number already exists.");
        }
    }
}
