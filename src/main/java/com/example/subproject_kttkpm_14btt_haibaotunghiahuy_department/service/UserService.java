package com.example.subproject_kttkpm_14btt_haibaotunghiahuy_department.service;


import com.example.subproject_kttkpm_14btt_haibaotunghiahuy_department.authen.UserPrincipal;
import com.example.subproject_kttkpm_14btt_haibaotunghiahuy_department.entity.User;

public interface UserService {
    User createUser(User user);
    UserPrincipal findByEmail(String email);
}
