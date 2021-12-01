package com.example.subproject_kttkpm_14btt_haibaotunghiahuy_department.controller;

import com.example.subproject_kttkpm_14btt_haibaotunghiahuy_department.authen.UserPrincipal;
import com.example.subproject_kttkpm_14btt_haibaotunghiahuy_department.entity.Department;
import com.example.subproject_kttkpm_14btt_haibaotunghiahuy_department.entity.Token;
import com.example.subproject_kttkpm_14btt_haibaotunghiahuy_department.entity.User;
import com.example.subproject_kttkpm_14btt_haibaotunghiahuy_department.service.DepartmentService;
import com.example.subproject_kttkpm_14btt_haibaotunghiahuy_department.service.TokenService;
import com.example.subproject_kttkpm_14btt_haibaotunghiahuy_department.service.UserService;
import com.example.subproject_kttkpm_14btt_haibaotunghiahuy_department.util.JwtUtil;
import com.example.subproject_kttkpm_14btt_haibaotunghiahuy_department.vo.ResponseTemplateVO;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
public class DepartmentController
{
    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private TokenService tokenService;
    @Value("${myName}")
    public String name;

    @PostMapping("/")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public Department saveDepartment(@RequestBody Department department){
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('USER')")
    public ResponseEntity<ResponseTemplateVO> getStudentWithDepartment(@PathVariable("id") Long id){
        return departmentService.getStudentWithDepartment(id);
    }

    @PostMapping("/register")
    public String register(@RequestBody User user){


        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userService.createUser(user);
        return "Register successful";
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user){

        UserPrincipal userPrincipal =
                userService.findByEmail(user.getEmail());

        if (null == user || !new BCryptPasswordEncoder()
                .matches(user.getPassword(), userPrincipal.getPassword())) {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Account or password is not valid!");
        }

        Token token = new Token();
        token.setToken(jwtUtil.generateToken(userPrincipal));

        token.setTokenExpDate(jwtUtil.generateExpirationDate());
        token.setCreatedBy(userPrincipal.getUserId());
        tokenService.createToken(token);

        return ResponseEntity.ok(token.getToken());
    }
    @GetMapping("/name")
    public String getName() {
        return name;
    }
}