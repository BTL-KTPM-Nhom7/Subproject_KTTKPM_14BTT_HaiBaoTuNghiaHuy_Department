package com.example.subproject_kttkpm_14btt_haibaotunghiahuy_department.service;


import com.example.subproject_kttkpm_14btt_haibaotunghiahuy_department.entity.Token;

public interface TokenService {
    Token createToken(Token token);

    Token findByToken(String token);
}
