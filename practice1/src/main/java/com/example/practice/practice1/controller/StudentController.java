package com.example.practice.practice1.controller;

import com.example.practice.practice1.entity.Laptop;
import com.example.practice.practice1.entity.Student;
import com.example.practice.practice1.service.LaptopService;
import com.example.practice.practice1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StudentController {

       @Autowired
       StudentService studentService;

       @Autowired
       LaptopService laptopService;


       @PostMapping("/student")
       Student createAccount(@RequestBody Student student){
              return studentService.createAccount(student);
       }

       @PostMapping("/laptop")
       Laptop createAccount(@RequestBody Laptop laptop){
              return laptopService.createAccount(laptop);
       }

}
