package com.sbhospitalmanagement.project.Model;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dId;
    private String dName;
    private String dSpecialization;
    private int age;
}
