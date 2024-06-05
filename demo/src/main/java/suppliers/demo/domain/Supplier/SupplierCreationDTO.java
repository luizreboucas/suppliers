package suppliers.demo.domain.Supplier;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import suppliers.demo.domain.Endereco;

public record SupplierCreationDTO (
        @NotBlank
        String nome,
        @NotBlank
        String cnpj,
        Endereco endereco
){}
