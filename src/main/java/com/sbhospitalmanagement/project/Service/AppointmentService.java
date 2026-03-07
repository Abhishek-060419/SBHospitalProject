package com.sbhospitalmanagement.project.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.servlet.context.ServletComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sbhospitalmanagement.project.Controller.AppointmentController;
import com.sbhospitalmanagement.project.Model.Appointment;
import com.sbhospitalmanagement.project.Repository.AppointmentRepository;

@Service
public class AppointmentService {
    
    private AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository){
        this.appointmentRepository=appointmentRepository;
    }

    //create a new appointment
    public ResponseEntity<Appointment>createNewAppointment(Appointment A){
        return new ResponseEntity<>(this.appointmentRepository.save(A),HttpStatus.CREATED);
    }
}
