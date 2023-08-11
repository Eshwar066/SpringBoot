//package com.example.practice.practice1.CrudOperation;
//
//import jakarta.persistence.*;
//
//@Entity
//@Table(name = "student")
//public class Student {
//    @Id
//    @SequenceGenerator(
//            name = "student_sequence",
//            sequenceName = "student_sequence",
//            allocationSize = 1
//    )
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "student_sequence"
//    )
//    private int id;
//    private String name;
//    private int age;
//    private String emial;
//    private Long ph_num;
//
//
//
//    public Student() {
//    }
//
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public String getEmial() {
//        return emial;
//    }
//
//    public void setEmial(String emial) {
//        this.emial = emial;
//    }
//
//    public double getPh_num() {
//        return ph_num;
//    }
//
//    public void setPh_num(Long ph_num) {
//        this.ph_num = ph_num;
//    }
//
//
//
//
//
//    public Student(int id, String name, int age, String emial, long ph_num) {
//        this.id = id;
//        this.name = name;
//        this.age = age;
//        this.emial = emial;
//        this.ph_num = ph_num;
//    }
//
//
//    @Override
//    public String toString() {
//        return "Student{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", age=" + age +
//                ", emial='" + emial + '\'' +
//                ", ph_num=" + ph_num +
//                '}';
//    }
//
//
//}
