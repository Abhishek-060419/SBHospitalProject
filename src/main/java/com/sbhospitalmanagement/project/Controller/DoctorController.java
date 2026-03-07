package com.sbhospitalmanagement.project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbhospitalmanagement.project.Model.Doctor;
import com.sbhospitalmanagement.project.Service.DoctorService;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    private DoctorService doctorsService;

    @Autowired
    public DoctorController(DoctorService doctorsService){
        this.doctorsService=doctorsService;
    }
    
    @PostMapping("/create")
    public ResponseEntity<Doctor> createNewDoctor(@RequestBody Doctor D){
        return doctorsService.createNewDoctor(D); 
    }

    @GetMapping("/get")
    public ResponseEntity<List<Doctor>> getAllDoctors(){
        return doctorsService.getAllDoctors();
    }

    @GetMapping("/get/{dId}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable Long dId){
        return doctorsService.getDoctorById(dId);
    }

    @PutMapping("/updateName/{dId}")
    public ResponseEntity<Doctor> updateDoctorNameById(@PathVariable Long dId, @RequestBody Doctor D){
        return doctorsService.udpateDoctorNameById(dId, D);
    }

    @PutMapping("/updateAge/{dId}")
    public ResponseEntity<Doctor> updateDoctorAgeById(@PathVariable Long dId, @RequestBody Doctor D){
        return doctorsService.udpateDoctorAgeById(dId, D);
    }

    @PutMapping("/updateSpecialization/{dId}")
    public ResponseEntity<Doctor> updateDoctorSpecializationById(@PathVariable Long dId, @RequestBody Doctor D){
        return doctorsService.udpateDoctorSpecializationById(dId, D);
    }

    @DeleteMapping("/delete/{dId}")
    public void deleteDoctorById(@PathVariable Long dId){
        doctorsService.deleteDoctorById(dId);
    }
}
