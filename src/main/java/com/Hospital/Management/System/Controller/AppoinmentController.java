package com.Hospital.Management.System.Controller;

import com.Hospital.Management.System.Model.Appoinments;
import com.Hospital.Management.System.Repo.AppoinmentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.AttributeNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//it is to maintain the request
@CrossOrigin(origins="http://localhost:4200/")
@RestController
@RequestMapping("api/v2")
public class AppoinmentController {

    AppoinmentRepository appoinmentRepository;

    public AppoinmentController(AppoinmentRepository appoinmentRepository) {
        super();
        this.appoinmentRepository = appoinmentRepository;
    }

    @PostMapping("/appointment")
    public Appoinments createAppoinment(@RequestBody Appoinments appoinments){
        return appoinmentRepository.save(appoinments);
    }

    @GetMapping("/appointment")
    public List<Appoinments> getAllAppoinments(){
        return appoinmentRepository.findAll();
    }

    @DeleteMapping("/appointment/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteAppointment(@PathVariable long id) throws AttributeNotFoundException {
         Appoinments appointment=appoinmentRepository.findById(id).orElseThrow(()-> new AttributeNotFoundException("Appointment not found by id "+id));

         appoinmentRepository.delete(appointment);
         Map<String,Boolean> response=new HashMap<String, Boolean>();
         response.put("Deleted",Boolean.TRUE);
         return ResponseEntity.ok(response);
    }
}
