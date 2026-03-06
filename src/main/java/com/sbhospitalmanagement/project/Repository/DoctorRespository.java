package com.sbhospitalmanagement.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sbhospitalmanagement.project.Model.Doctor;

public interface DoctorRespository extends JpaRepository<Doctor,Long> {
    
}
