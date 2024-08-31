package com.Hospital.Management.System.Controller;

import com.Hospital.Management.System.Model.Patients;
import com.Hospital.Management.System.Repo.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.AttributeNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    public PatientController(PatientRepository patientRepository) {

        super();
        this.patientRepository = patientRepository;
    }

    @PostMapping("/patients")
    public Patients createPatient(@RequestBody Patients patients){

        return patientRepository.save(patients);
    }

    @GetMapping("/patients")
    public List<Patients> getAllPatient(){
        System.out.println(patientRepository.findAll());
        return patientRepository.findAll();
    }


    @GetMapping("/patients/{id}")
    public ResponseEntity<Patients> getPatientById(@PathVariable long id) throws AttributeNotFoundException {
        Patients patient=patientRepository.findById(id).orElseThrow(()->new AttributeNotFoundException("Patient not found by  the id "+id));
        return ResponseEntity.ok(patient);
    }


    @DeleteMapping("/patients/{id}")
    public ResponseEntity<Map<String,Boolean>> deletePatient(@PathVariable long id) throws AttributeNotFoundException {
        Patients patient=patientRepository.findById(id).orElseThrow(()-> new AttributeNotFoundException("Patient not found by id "+id));

        patientRepository.delete(patient);
        Map<String,Boolean> response=new HashMap<String, Boolean>();
        response.put("Deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/patients/{id}")
    public ResponseEntity<Patients> updatePatientById(@PathVariable long id,@RequestBody Patients patientDetails) throws AttributeNotFoundException {
        Patients patient=patientRepository.findById(id).orElseThrow(()-> new AttributeNotFoundException("Patient not found by id "+id));

        patient.setAge(patientDetails.getAge());
        patient.setName(patientDetails.getName());
        patient.setBlood(patientDetails.getBlood());
        patient.setDose(patientDetails.getDose());
        patient.setFees(patientDetails.getFees());
        patient.setPrescription(patientDetails.getPrescription());
        patient.setUrgency(patientDetails.getUrgency());


        Patients savedPatient=patientRepository.save(patient);
        return ResponseEntity.ok(savedPatient);

    }
}
