package com.sbhospitalmanagement.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sbhospitalmanagement.project.Model.Bill;

public interface BillRepository extends JpaRepository<Bill,Long> {

    
}