package com.example.practice.practice1.service;

import com.example.practice.practice1.entity.Student;
import org.springframework.stereotype.Service;

@Service
public interface StudentService {

     Student createAccount(Student student);
}
