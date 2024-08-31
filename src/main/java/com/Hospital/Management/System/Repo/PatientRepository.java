package com.Hospital.Management.System.Repo;

import com.Hospital.Management.System.Model.Patients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//it is responsible for database function
@Repository
public interface PatientRepository extends JpaRepository<Patients, Long> {

}
