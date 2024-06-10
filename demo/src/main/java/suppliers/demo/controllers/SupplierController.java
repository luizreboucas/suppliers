package suppliers.demo.controllers;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import suppliers.demo.domain.Supplier.Supplier;
import suppliers.demo.domain.Supplier.SupplierCreationDTO;
import suppliers.demo.domain.Supplier.SupplierDTO;
import suppliers.demo.services.SupplierService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/suppliers")
public class SupplierController {

    @Autowired
    SupplierService supplierService;

    @GetMapping()
    public ResponseEntity<Page<SupplierDTO>> getAllSuppliers(Pageable pagination){

        var suppliers = supplierService.getAllSuppliers(pagination);
        return ResponseEntity.ok(suppliers);
    }

    @GetMapping("/{supplierId}")
    public ResponseEntity<SupplierDTO> getSupplier(@PathVariable Long supplierId){
        var supplier = supplierService.getSupplier(supplierId);
        return ResponseEntity.ok(supplier);
    }

    @PostMapping()
    @Transactional
    public ResponseEntity<SupplierDTO> createSupplier(@RequestBody SupplierCreationDTO supplier){

        SupplierDTO newSupplier = supplierService.createSupplier(supplier);
        return ResponseEntity.ok(newSupplier);
    }

    @Transactional
    @PutMapping("/{supplierId}")
    public ResponseEntity<SupplierDTO> updateSupplier(@RequestBody SupplierCreationDTO supplierNewData, @PathVariable Long supplierId){
        SupplierDTO updatedSupplier = supplierService.updateSupplier(supplierNewData, supplierId);
        return ResponseEntity.ok(updatedSupplier);
    }

    @Transactional
    @DeleteMapping("/{supplierId}")
    public ResponseEntity<String> deleteSupplier(@PathVariable Long supplierId){
        supplierService.deleteSupplier(supplierId);
        return ResponseEntity.ok("fornecedor deletado com sucesso");
    }


}
