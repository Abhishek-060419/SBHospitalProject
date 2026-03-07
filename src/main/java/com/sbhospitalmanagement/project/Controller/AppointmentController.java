package com.sbhospitalmanagement.project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbhospitalmanagement.project.Model.Appointment;
import com.sbhospitalmanagement.project.Service.AppointmentService;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    
    private AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService){
        this.appointmentService=appointmentService;
    }

    @PostMapping("/create")
    public ResponseEntity<Appointment> createNewAppointment(Appointment A){
        return this.appointmentService.createNewAppointment(A);
    }
}
