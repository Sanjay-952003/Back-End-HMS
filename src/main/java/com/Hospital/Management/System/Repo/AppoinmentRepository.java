package com.Hospital.Management.System.Repo;

import com.Hospital.Management.System.Model.Appoinments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppoinmentRepository extends JpaRepository<Appoinments, Long> {
}
