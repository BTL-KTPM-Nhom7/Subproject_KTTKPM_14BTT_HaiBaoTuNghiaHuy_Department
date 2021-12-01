package com.example.subproject_kttkpm_14btt_haibaotunghiahuy_department.service;

import com.example.subproject_kttkpm_14btt_haibaotunghiahuy_department.entity.Token;
import com.example.subproject_kttkpm_14btt_haibaotunghiahuy_department.repository.TokenRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService {
    @Autowired
    private TokenRepository tokenRepository;
    @Override
    public Token createToken(Token token) {
        return tokenRepository.saveAndFlush(token);
    }

    @Override
    public Token findByToken(String token) {
        return tokenRepository.findByToken(token);
    }
}
