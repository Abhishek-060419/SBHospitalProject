package com.sbhospitalmanagement.project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    
    
    @PostMapping("/create")
    public Patient createNewPatient(@RequestBody Patient P){
        return patientService.createNewPatient(P);
    }
}
