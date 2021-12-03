package com.example.subproject_kttkpm_14btt_haibaotunghiahuy_department.service;

import com.example.subproject_kttkpm_14btt_haibaotunghiahuy_department.entity.Role;
import com.example.subproject_kttkpm_14btt_haibaotunghiahuy_department.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public Role addNewRole(Role r){
        roleRepository.save(r);
        return r;
    }
}
