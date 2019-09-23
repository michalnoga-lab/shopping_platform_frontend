package com.app.tools;

import com.app.model.Company;
import com.app.model.User;
import com.app.repository.CompanyRepository;
import com.app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class dataInitialization implements CommandLineRunner {

    private final CompanyRepository companyRepository;
    private final UserRepository userRepository;

    Company company1 = Company.builder()
            .name("company 1")
            .nip("123456")
            .build();
    Company company2 = Company.builder()
            .name("company 2")
            .nip("234567")
            .build();

    User user1 = User.builder()
            .login("log")
            .name("name 1")
            .build();
    User user2 = User.builder()
            .login("log2")
            .name("name 2")
            .build();

    @Override
    public void run(String... args) throws Exception {

        companyRepository.saveAll(List.of(company1, company2));
        userRepository.saveAll(List.of(user1, user2));

        user1.setCompany(company1);
        user2.setCompany(company1);

        userRepository.saveAndFlush(user1);
    }
}