package com.example.subproject_kttkpm_14btt_haibaotunghiahuy_department.service;

import com.example.subproject_kttkpm_14btt_haibaotunghiahuy_department.entity.Department;
import com.example.subproject_kttkpm_14btt_haibaotunghiahuy_department.entity.Student;
import com.example.subproject_kttkpm_14btt_haibaotunghiahuy_department.repository.DepartmentRepository;
import com.example.subproject_kttkpm_14btt_haibaotunghiahuy_department.vo.ResponseTemplateVO;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private int flag = 0;

    @Retry(name= "basic", fallbackMethod = "fallbackRetry")
    public ResponseEntity<ResponseTemplateVO> getStudentWithDepartment(Long departmentId) {
        flag = flag + 1;
        System.out.print("retry lan" + flag);
        ResponseTemplateVO vo = new ResponseTemplateVO();
        Department department = departmentRepository.findById(departmentId).get();
        vo.setDepartment(department);
        Student student = restTemplate.getForObject("http://localhost:8080/student/"
                                + department.getStudentId(),
                Student.class);

        vo.setStudent(student);
        return  new ResponseEntity<ResponseTemplateVO>(vo, HttpStatus.OK);
    }
    public ResponseEntity <String> fallbackRetry(RuntimeException e){
        flag = 0;
        System.out.print("error" + e.getMessage());
        ResponseTemplateVO vo = new ResponseTemplateVO();
        return new ResponseEntity <String>("Du lieu khong thanh cong",HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
