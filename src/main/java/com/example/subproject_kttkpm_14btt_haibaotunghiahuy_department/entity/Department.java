package com.example.subproject_kttkpm_14btt_haibaotunghiahuy_department.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "department_service")
public class Department {
    @Id
    @GeneratedValue
    private long departmentId;
    private String name;
    private Long studentId;
}
