package suppliers.demo.domain.Supplier;

import jakarta.persistence.Embedded;
import suppliers.demo.domain.Endereco;

public record SupplierDTO (
        Long id,
        String nome,
        String cnpj,
        Endereco endereco
){
    public SupplierDTO(Supplier supplier){
        this(supplier.getId(),supplier.getNome(),supplier.getCnpj(), supplier.getEndereco());
    }
}
