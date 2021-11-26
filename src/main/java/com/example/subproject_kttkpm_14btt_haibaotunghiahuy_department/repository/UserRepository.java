package com.example.subproject_kttkpm_14btt_haibaotunghiahuy_department.repository;


import com.example.subproject_kttkpm_14btt_haibaotunghiahuy_department.entity.User;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;

@Registered
public interface UserRepository extends JpaRepository<User, Long> {
    //User findByUsername(String username);
    User findByEmail(String email);
}
