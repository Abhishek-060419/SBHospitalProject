package com.sbhospitalmanagement.project.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    
    //For Creating a new Patient record
    public ResponseEntity<Patient> createNewPatient(Patient P){
        return new ResponseEntity<>(patientRepository.save(P),HttpStatus.CREATED); 
    }

    //For getting all patients records
    public ResponseEntity<List<Patient>> getAllPatients(){
        return new ResponseEntity<>(patientRepository.findAll(),HttpStatus.OK);
    }

    //For fetching a patient using pid
    public ResponseEntity<Patient> getPatientById(Long pid){
        return new ResponseEntity<>(patientRepository.findById(pid).orElseThrow(()->new RuntimeException("Patient not found!")),HttpStatus.FOUND);
    }

    //For updating a patient's record(name) using his/her pid
    public ResponseEntity<Patient> updatePatientNameById(Long pid,Patient patient){
        Patient existingPatient= patientRepository.findById(pid).orElseThrow(()->new RuntimeException("Patient not found!"));
        existingPatient.setPName(patient.getPName());
        patientRepository.save(existingPatient);
        return new ResponseEntity<>(existingPatient,HttpStatus.OK);
    }

    //For updating a patient's record(age) using his/her pid
    public ResponseEntity<Patient> updatePatientAgeById(Long pid,Patient patient){
        Patient existingPatient= patientRepository.findById(pid).orElseThrow(()->new RuntimeException("Patient not found!"));
        existingPatient.setPAge(patient.getPAge());
        patientRepository.save(existingPatient);
        return new ResponseEntity<>(existingPatient,HttpStatus.OK);
    }

    //For updating a patient's record(gender) using his/her pid
    public ResponseEntity<Patient> updatePatientGenderById(Long pid,Patient patient){
        Patient existingPatient= patientRepository.findById(pid).orElseThrow(()->new RuntimeException("Patient not found!"));
        existingPatient.setPGender(patient.getPGender());
        patientRepository.save(existingPatient);
        return new ResponseEntity<>(existingPatient,HttpStatus.OK);
    }
    
    //For deleting a patient using his/her id
    public void deletePatientById(Long pid){
        patientRepository.deleteById(pid);
    }
}

