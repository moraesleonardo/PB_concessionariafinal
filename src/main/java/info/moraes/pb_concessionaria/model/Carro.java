package info.moraes.pb_concessionaria.model;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class Carro {
    @NotBlank
    private int codigo;
    @NotBlank
    @Size(min = 0, max = 20)
    private String nome;
    private String tipo;
}


