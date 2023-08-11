//package com.example.practice.practice1.CrudOperation;
//
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.time.LocalDate;
//import java.time.Month;
//import java.util.List;
//@Configuration
//public class StundentConfig {
//
//
//
//        @Bean
//        CommandLineRunner commandLineRunner(StudentRepositay repositay){
//            return args ->{
//                Student eshwar = new Student(
//                        1,
//                        "eshwar",
//                        22,
//                        "eshwarsairam@gmail.com",
//                        636362672
//                );
//
//                Student sai = new Student(
//
//                        2,
//                        "sai",
//                        32,
//                        "eshwarsairam@gmail.com",
//                        636363672
//                );
//
//                repositay.saveAll(
//                        List.of(eshwar,sai)
//                );
//
//            };
//        }
//    }
//
