package com.Hospital.Management.System.Controller;

import com.Hospital.Management.System.Model.Patients;
import com.Hospital.Management.System.Repo.PatientRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

public class AdminController {

    @Autowired
    private PatientRepository patientRepository;
    private List<Patients> patients=new ArrayList<>();
    @GetMapping("/api/v1/patients")
    public List<Patients> getPatients(){
        return patientRepository.findAll();
    }
    @GetMapping("/csrf-token")
    public CsrfToken csrftoken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping("/api/v1/patients")
    public Patients addstudent(@RequestBody Patients patient){
        return patientRepository.save(patient);
    }
}