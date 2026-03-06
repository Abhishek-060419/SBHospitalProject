package com.sbhospitalmanagement.project.Service;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sbhospitalmanagement.project.Model.Doctor;
import com.sbhospitalmanagement.project.Repository.DoctorRespository;

@Service
public class DoctorService {
    
    private DoctorRespository doctorRespository;

    @Autowired
    public DoctorService(DoctorRespository doctorRespository){
        this.doctorRespository=doctorRespository;
    }

    //Create new Doctor
    public ResponseEntity<Doctor> createNewDoctor(Doctor D){
        return new ResponseEntity<>(doctorRespository.save(D),HttpStatus.CREATED);
    }

    //Get all doctors
    public ResponseEntity<List<Doctor>> getAllDoctors(){
        return new ResponseEntity<>(doctorRespository.findAll(),HttpStatus.OK);
    }

    //Get doctor by id
    public ResponseEntity<Doctor> getDoctorById(Long dId){
        return new ResponseEntity<>(doctorRespository.findById(dId).orElseThrow(()->new RuntimeException("Doctor not found!")),HttpStatus.OK);
    }

    //Update doctor name
    public ResponseEntity<Doctor> udpateDoctorNameById(Long dId, Doctor D){
        Doctor existingDoctor=doctorRespository.findById(dId).orElseThrow(()->new RuntimeException("Doctor Not found!"));
        existingDoctor.setDName(D.getDName());
        doctorRespository.save(existingDoctor);
        return new ResponseEntity<>(existingDoctor,HttpStatus.ACCEPTED);
    }

    //Update doctor age
    public ResponseEntity<Doctor> udpateDoctorAgeById(Long dId, Doctor D){
        Doctor existingDoctor=doctorRespository.findById(dId).orElseThrow(()->new RuntimeException("Doctor Not found!"));
        existingDoctor.setDAge(D.getDAge());
        doctorRespository.save(existingDoctor);
        return new ResponseEntity<>(existingDoctor,HttpStatus.ACCEPTED);
    }

    //Update doctor specialization
    public ResponseEntity<Doctor> udpateDoctorSpecializationById(Long dId, Doctor D){
        Doctor existingDoctor=doctorRespository.findById(dId).orElseThrow(()->new RuntimeException("Doctor Not found!"));
        existingDoctor.setDSpecialization(D.getDSpecialization());
        doctorRespository.save(existingDoctor);
        return new ResponseEntity<>(existingDoctor,HttpStatus.ACCEPTED);
    }

    //Delete doctor by id
    public void deleteDoctorById(Long dId){
        doctorRespository.deleteById(dId);
    }

}