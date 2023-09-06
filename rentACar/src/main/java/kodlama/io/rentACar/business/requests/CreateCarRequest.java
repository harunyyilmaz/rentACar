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
public class CreateCarRequest {
    @NotNull
    @NotBlank
    private String plate;

    @NotBlank
    @NotNull
    private double dailyPrice;

    @NotBlank
    @NotNull
    private int modelYear;

    @NotBlank
    @NotNull
    private String state;
}
