package com.example.practice.practice1.service;

import com.example.practice.practice1.entity.Laptop;
import com.example.practice.practice1.entity.Student;
import com.example.practice.practice1.repositary.LaptopRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaptopServiceimpl implements LaptopService{
    @Autowired
    private LaptopRepositary laptopRepositary;

    @Override
    public Laptop createAccount(Laptop laptop) {
        Laptop newuser=Laptop.builder()
                .laptopName(laptop.getLaptopName())
                .modelNum(laptop.getModelNum())
                .build();

        Laptop savedinfo=laptopRepositary.save(newuser);

        return Laptop.builder()
                .laptopName(savedinfo.getLaptopName())
                .modelNum(savedinfo.getModelNum())
                .build();
    }
}
