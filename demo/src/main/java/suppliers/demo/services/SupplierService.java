package suppliers.demo.services;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import suppliers.demo.domain.Supplier.Supplier;
import suppliers.demo.domain.Supplier.SupplierCreationDTO;
import suppliers.demo.domain.Supplier.SupplierDTO;
import suppliers.demo.domain.Supplier.SupplierRepository;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public Page<SupplierDTO> getAllSuppliers(Pageable pagination){
        return supplierRepository.findAll(pagination).map(SupplierDTO::new);
    }

    public SupplierDTO createSupplier(@Valid SupplierCreationDTO supplier){
        Supplier newSupplier = new Supplier(supplier);
        supplierRepository.save(newSupplier);
        return new SupplierDTO(newSupplier);
    }

    public SupplierDTO updateSupplier(SupplierCreationDTO supplierNewData, Long supplierId){
        if(supplierId == null) throw new RuntimeException("id de fornecedor não fornecido");
        if(!supplierRepository.existsById(supplierId)) throw new RuntimeException("fornecedor não encontrado");
        Supplier supplier = supplierRepository.findById(supplierId).get();
        supplier.update(supplierNewData);
        return new SupplierDTO(supplier);
    }

    public Boolean deleteSupplier(Long supplierId){
        if(!supplierRepository.existsById(supplierId)) throw new RuntimeException("fornecedor não encontrado");
        supplierRepository.deleteById(supplierId);
        return true;
    }

    public SupplierDTO getSupplier(Long id){
        if(!supplierRepository.existsById(id)) throw new RuntimeException("Supplier não encontrado");
        Supplier supplier = supplierRepository.findById(id).get();
        return new SupplierDTO(supplier);
    }

}
