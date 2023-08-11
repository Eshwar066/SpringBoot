package com.example.practice.practice1.repositary;


import com.example.practice.practice1.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface StudentRepository extends JpaRepository<Student,Integer> {

    Boolean existsByEmail(String email);

}
