package kodlama.io.rentACar.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCustomerRequest {
    @NotNull
    @NotBlank
    private int id;
    @NotNull
    @NotBlank
    private String userName;
    @NotNull
    @NotBlank
    @Size(min = 5 , max = 20)
    private int password;
    @NotNull
    @NotBlank
    private String lastName;
    @NotNull
    @NotBlank
    private String firstName;

}
