package com.example.subproject_kttkpm_14btt_haibaotunghiahuy_department.service;

import com.example.subproject_kttkpm_14btt_haibaotunghiahuy_department.entity.Department;
import com.example.subproject_kttkpm_14btt_haibaotunghiahuy_department.entity.Student;
import com.example.subproject_kttkpm_14btt_haibaotunghiahuy_department.repository.DepartmentRepository;
import com.example.subproject_kttkpm_14btt_haibaotunghiahuy_department.vo.ResponseTemplateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;


    @Autowired
    private RestTemplate restTemplate;

    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public ResponseTemplateVO getStudentWithDepartment(Long departmentId) {
        ResponseTemplateVO vo = new ResponseTemplateVO();
        Department department = departmentRepository.findById(departmentId).get();
        vo.setDepartment(department);
        Student student = restTemplate.getForObject("http://localhost:8080/student/"
                                + department.getStudentId(),
                Student.class);

        vo.setStudent(student);
        return vo;
    }
}
