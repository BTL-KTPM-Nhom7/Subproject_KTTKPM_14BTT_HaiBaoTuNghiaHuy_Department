package com.example.subproject_kttkpm_14btt_haibaotunghiahuy_department.repository;


import com.example.subproject_kttkpm_14btt_haibaotunghiahuy_department.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {
    Token findByToken(String token);
}
