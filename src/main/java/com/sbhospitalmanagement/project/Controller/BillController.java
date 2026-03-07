package com.sbhospitalmanagement.project.Controller;

import java.util.List;
import com.sbhospitalmanagement.project.Model.Bill;
import com.sbhospitalmanagement.project.Model.Doctor;
import com.sbhospitalmanagement.project.Model.Patient;
import com.sbhospitalmanagement.project.Service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bill")
public class BillController {
    
    private BillService billService;

    @Autowired
    public BillController(BillService billService){
        this.billService=billService;
    }

    @GetMapping("/create")
    public ResponseEntity<Bill> createNewBill(Bill B){
        return this.billService.createNewBill(B);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Bill>> getAllBills(){
        return billService.getAllBills();
    }

    @GetMapping("/get/{bId}")
    public ResponseEntity<Bill> getBillById(@PathVariable Long bId){
        return billService.getBillById(bId);
    } 
    
    @PutMapping("/updatePid/{bId}")
    public ResponseEntity<Bill> updatePatientIdByBillId(@PathVariable Long bId,@RequestBody Patient p){
        return billService.updatePatientIdByBillId(bId, p);
    }

    @PutMapping("/updateAmount/{bId}/{newAmount}")
    public ResponseEntity<Bill> updateAmountByBillId(@PathVariable Long bId,@PathVariable Double newAmount){
        return billService.updateAmountByBillId(bId, newAmount);
    }

    @PutMapping("/updateStatus/{bId}/{status}")
    public ResponseEntity<Bill> updateStatusByBillId(@PathVariable Long bId,@PathVariable String status){
        return billService.updateStatusByBillId(bId, status);
    }


    @DeleteMapping("/delete/{bId}")
    public void deleteBillById(@PathVariable Long bId){
        this.billService.deleteBillById(bId);
    }

}

