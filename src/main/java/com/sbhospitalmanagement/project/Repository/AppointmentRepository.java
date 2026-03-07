package com.sbhospitalmanagement.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sbhospitalmanagement.project.Model.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {

    
}
