package com.example.subproject_kttkpm_14btt_haibaotunghiahuy_department.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Long studentId;

    private String name;

    private String address;
    private String className;
}