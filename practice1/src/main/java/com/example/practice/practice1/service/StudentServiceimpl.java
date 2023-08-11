package com.example.practice.practice1.service;


import com.example.practice.practice1.entity.Student;
import com.example.practice.practice1.repositary.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentServiceimpl implements StudentService {


    @Autowired
    private StudentRepository studentRepository;


    @Override
    public Student createAccount(Student student) {

        Student newUser=Student.builder()
                .name(student.getName())
                .age(student.getAge())
                .email(student.getEmail())
                .build();

        Student savedStudent=studentRepository.save(newUser);

        return Student.builder()
                .name(savedStudent.getName())
                .age(savedStudent.getAge())
                .email(savedStudent.getEmail())
                .build();
    }
}
