//package com.example.practice.practice1.CrudOperation;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping(path="api/v2/student")
//public class StudentController {
//
//    @Autowired
//    private final StudentServices studentServices;
//
//    public StudentController(StudentServices studentServices) {
//        this.studentServices = studentServices;
//    }
//
//
//    @GetMapping
//    public List<Student> getStudent(){
//        return studentServices.getStudent();
//    }
//
//    @PostMapping
//    public void registerNewStudent(@RequestBody Student student){
//        studentServices.addNewStudent(student);
//    }
//
//}
