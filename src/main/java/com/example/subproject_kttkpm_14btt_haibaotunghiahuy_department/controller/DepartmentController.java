package com.example.subproject_kttkpm_14btt_haibaotunghiahuy_department.controller;

import com.example.subproject_kttkpm_14btt_haibaotunghiahuy_department.entity.Department;
import com.example.subproject_kttkpm_14btt_haibaotunghiahuy_department.service.DepartmentService;
import com.example.subproject_kttkpm_14btt_haibaotunghiahuy_department.vo.ResponseTemplateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
public class DepartmentController
{
    @Autowired
    private DepartmentService departmentService;

    @Value("${myName}")
    public String name;

    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department department){
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseTemplateVO> getStudentWithDepartment(@PathVariable("id") Long id){
        return departmentService.getStudentWithDepartment(id);
    }
    @GetMapping("/name")
    public String getName() {
        return name;
    }
}