package com.sbhospitalmanagement.project.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;

import com.sbhospitalmanagement.project.Model.Patient;
import com.sbhospitalmanagement.project.Service.PatientService;

@RestController
@RequestMapping("/patient")
public class PatientController {

    private PatientService patientService;

    @Autowired
    public PatientController( PatientService patientService){
        this.patientService=patientService;
    }
    
    //For creating a new patient record
    @PostMapping("/create")
    public ResponseEntity<Patient> createNewPatient(@RequestBody Patient P){
        return patientService.createNewPatient(P);
    }

    //For fetching all pateints records
    @GetMapping("/get")
    public ResponseEntity<List<Patient>> getAllPatients(){
        return patientService.getAllPatients();
    }

    //For getting a patient via pid
    @GetMapping("/get/pid")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long pid){
        return patientService.getPatientById(pid);
    }

    //For updating patient name 
    @PutMapping("/updateName/pid")
    public ResponseEntity<Patient>updatePatientName(@PathVariable Long pid, @RequestBody Patient patient){
        return patientService.updatePatientNameById(pid,patient);
    }

    //For updating patient age
    @PutMapping("/updateAge/pid")
    public ResponseEntity<Patient>updatePatientAge(@PathVariable Long pid, @RequestBody Patient patient){
        return patientService.updatePatientAgeById(pid,patient);
    }

    //For updating patien gender
    @PutMapping("/update/pid")
    public ResponseEntity<Patient>updatePatientGender(@PathVariable Long pid, @RequestBody Patient patient){
        return patientService.updatePatientGenderById(pid,patient);
    }

    //Deleting a patient 
    @DeleteMapping("/delete/pid")
    public void deletePatientById(@PathVariable Long pid){
        patientService.deletePatientById(pid);
    }
}
