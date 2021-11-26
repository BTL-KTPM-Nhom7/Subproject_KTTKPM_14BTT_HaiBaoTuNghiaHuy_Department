package com.example.subproject_kttkpm_14btt_haibaotunghiahuy_department.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "t_role")
@Getter
@Setter
public class Role extends BaseEntity {

    private String roleName;

    @ManyToMany(mappedBy = "roles",fetch = FetchType.EAGER)
    private Set<User> users = new HashSet<>();


}
