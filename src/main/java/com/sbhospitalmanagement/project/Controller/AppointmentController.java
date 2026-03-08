package com.sbhospitalmanagement.project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
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

    @GetMapping("/get")
    public ResponseEntity<List<Appointment>> getAllAppointments(){
        return this.appointmentService.getAllAppointments();
    }

    @GetMapping("/get/{aId}")
    public ResponseEntity<Appointment>getAppointmentById(@PathVariable Long aId){
        return this.appointmentService.getAppointmentById(aId);
    }

    @PutMapping("/updatePid/{pId}")
    public ResponseEntity<Appointment>updatePatientIdInAppointment(@PathVariable Long pId){
        return this.appointmentService.updatePIdInAppointment(pId);
    }

    @PutMapping("/updateDid/{dId}")
    public ResponseEntity<Appointment>updateDoctorIdInAppointment(@PathVariable Long dId){
        return this.appointmentService.updateDIdInAppointment(dId);
    }

    @DeleteMapping("/delete/{aId}")
    public void deleteAppointmentById(@PathVariable Long aId){
        this.appointmentService.deleteAppointmentById(aId);
    }
}
