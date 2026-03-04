package com.sbhospitalmanagement.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sbhospitalmanagement.project.Model.Patient;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    
}
