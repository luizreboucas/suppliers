package suppliers.demo.domain.Supplier;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import suppliers.demo.domain.Endereco;

@Entity(name = "Supplier")
@Table(name = "suppliers")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cnpj;
    @Embedded
    private Endereco endereco;

    public Supplier(SupplierCreationDTO supplier){
        this.nome = supplier.nome();
        this.cnpj = supplier.cnpj();
        this.endereco = supplier.endereco();
    }

    public void update(SupplierCreationDTO supplierData){
        if(supplierData.cnpj() != null) this.cnpj = supplierData.cnpj();
        if(supplierData.nome() != null) this.nome = supplierData.nome();
        if(supplierData.endereco() != null) this.endereco = supplierData.endereco();
    }
}
