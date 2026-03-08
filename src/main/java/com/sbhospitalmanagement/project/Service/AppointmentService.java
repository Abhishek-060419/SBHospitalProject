package com.sbhospitalmanagement.project.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.servlet.context.ServletComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.*;
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

    //get all appointments
    public ResponseEntity<List<Appointment>>getAllAppointments(){
        return new ResponseEntity<>(appointmentRepository.findAll(),HttpStatus.FOUND);
    }

    //get by id
    public ResponseEntity<Appointment> getAppointmentById(Long aId){
        return new ResponseEntity<>(appointmentRepository.findById(aId).orElseThrow(()->new RuntimeException("Appointment Not found")),HttpStatus.FOUND);
    }

    //update patient id
    public ResponseEntity<Appointment>updatePIdInAppointment(Long pId){
        Appointment a=appointmentRepository.findById(pId).orElseThrow(()->new RuntimeException("Appointment Not found"));
        a.setPatientId(pId);
        return new ResponseEntity<>(appointmentRepository.save(a),HttpStatus.OK);
    }

    //update patient id
    public ResponseEntity<Appointment>updateDIdInAppointment(Long dId){
        Appointment a=appointmentRepository.findById(dId).orElseThrow(()->new RuntimeException("Appointment Not found"));
        a.setPatientId(dId);
        return new ResponseEntity<>(appointmentRepository.save(a),HttpStatus.OK);
    }

    //delete by id
    public void deleteAppointmentById(Long aId){
        this.appointmentRepository.deleteById(aId);
    }
}
