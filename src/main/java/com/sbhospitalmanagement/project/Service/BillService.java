package com.sbhospitalmanagement.project.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.*;
import com.sbhospitalmanagement.project.Repository.BillRepository;
import com.sbhospitalmanagement.project.Repository.PatientRepository;
import com.sbhospitalmanagement.project.Model.Bill;
import com.sbhospitalmanagement.project.Model.Doctor;
import com.sbhospitalmanagement.project.Model.Patient;

@Service
public class BillService{

    private BillRepository billRepository;
    private PatientRepository patientRepository;

    @Autowired
    public BillService(BillRepository billRepository){
        this.billRepository=billRepository;
    }

    @Autowired
    public BillService(PatientRepository patientRepository){
        this.patientRepository=patientRepository;
    }

    public ResponseEntity<Bill> createNewBill(Bill B){
        return new ResponseEntity<>(this.billRepository.save(B),HttpStatus.CREATED);
    }

    //Get all doctors
    public ResponseEntity<List<Bill>> getAllBills(){
        return new ResponseEntity<>(billRepository.findAll(),HttpStatus.OK);
    }

    //Get bill by id
    public ResponseEntity<Bill> getBillById(Long bId){
        return new ResponseEntity<>(billRepository.findById(bId).orElseThrow(()->new RuntimeException("Bill not found!")),HttpStatus.OK);
    }

    //update patientId in bill by billId
    public ResponseEntity<Bill>updatePatientIdByBillId(Long bId, Patient P){
        Bill exisitingBill=billRepository.findById(bId).orElseThrow(()->new RuntimeException("Bill not found!"));
        exisitingBill.setPatientId(P.getPId());
        billRepository.save(exisitingBill);
        return new ResponseEntity<>(exisitingBill,HttpStatus.OK);
    }

    //update amount in bill by billId
    public ResponseEntity<Bill>updateAmountByBillId(Long bId, Double newamount){
        Bill exisitingBill=billRepository.findById(bId).orElseThrow(()->new RuntimeException("Bill not found!"));
        exisitingBill.setAmount(newamount);
        billRepository.save(exisitingBill);
        return new ResponseEntity<>(exisitingBill,HttpStatus.OK);
    }

    //update status in bill by billId
    public ResponseEntity<Bill>updateStatusByBillId(Long bId, String status){
        Bill exisitingBill=billRepository.findById(bId).orElseThrow(()->new RuntimeException("Bill not found!"));
        exisitingBill.setStatus(status);
        billRepository.save(exisitingBill);
        return new ResponseEntity<>(exisitingBill,HttpStatus.OK);
    }

    //delete bill by id
    public void deleteBillById(Long bId){
        this.billRepository.deleteById(bId);
    }
}