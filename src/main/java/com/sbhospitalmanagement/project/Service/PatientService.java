package com.sbhospitalmanagement.project.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sbhospitalmanagement.project.Model.Patient;
import com.sbhospitalmanagement.project.Repository.PatientRepository;

@Service
public class PatientService {

    private PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository){
        this.patientRepository=patientRepository;
    }
    

    public Patient createNewPatient(Patient P){
        return patientRepository.save(P); 
    }
}
