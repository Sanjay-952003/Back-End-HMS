package com.Hospital.Management.System.Controller;

import com.Hospital.Management.System.Model.Medicine;
import com.Hospital.Management.System.Repo.MedicineRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.AttributeNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("api/v3")
public class MedicineController {

    MedicineRepository medicineRepository;

    public MedicineController(MedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }

    @PostMapping("/medicines")
    public Medicine createMedicine(@RequestBody Medicine medicine){
        return medicineRepository.save(medicine);
    }

    @GetMapping("/medicines")
    public List<Medicine> getAllMedicine(){
        return medicineRepository.findAll();
    }

    @GetMapping("/medicines/{id}")
    public ResponseEntity<Medicine> getMedicineById(@PathVariable long id) throws AttributeNotFoundException {
        Medicine medicine=medicineRepository.findById(id).orElseThrow(()->new AttributeNotFoundException("Medicine not found with id "+id));
        return ResponseEntity.ok(medicine);
    }

    @DeleteMapping("/medicines/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteMedicine(@PathVariable long id) throws AttributeNotFoundException {
        Medicine medicine=medicineRepository.findById(id).orElseThrow(()-> new AttributeNotFoundException("Medicine not found by id "+id));

        medicineRepository.delete(medicine);
        Map<String,Boolean> response=new HashMap<String, Boolean>();
        response.put("Deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/medicines/{id}")
    public ResponseEntity<Medicine> updateMedicineById(@PathVariable long id,@RequestBody Medicine medicineDetails) throws AttributeNotFoundException {
        Medicine medicine=medicineRepository.findById(id).orElseThrow(()->new AttributeNotFoundException("Medicine not found with id "+id));

        medicine.setDrug_name(medicineDetails.getDrug_name());
        medicine.setStock(medicineDetails.getStock());

        Medicine savedMedicine=medicineRepository.save(medicine);
        return ResponseEntity.ok(savedMedicine);
    }
}
