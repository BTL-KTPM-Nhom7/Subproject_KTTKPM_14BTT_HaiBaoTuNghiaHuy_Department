package com.example.subproject_kttkpm_14btt_haibaotunghiahuy_department;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableJpaAuditing
public class SubprojectKttkpm14BttHaiBaoTuNghiaHuyDepartmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(SubprojectKttkpm14BttHaiBaoTuNghiaHuyDepartmentApplication.class, args);
    }
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
