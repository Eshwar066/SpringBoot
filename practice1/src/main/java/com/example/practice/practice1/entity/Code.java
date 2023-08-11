package com.example.practice.practice1.entity;

public class Code {
    public static void main(String[] args) {
        Laptop laptop=new Laptop(1,"MI","2121");


        Student stud1=new Student(1,"navya","22","navyasai@gamil.com",laptop);
        System.out.println(stud1);
    }
}
