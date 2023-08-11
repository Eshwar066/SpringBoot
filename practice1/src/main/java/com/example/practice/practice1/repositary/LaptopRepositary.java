package com.example.practice.practice1.repositary;

import com.example.practice.practice1.entity.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaptopRepositary extends JpaRepository<Laptop,Integer> {
        boolean existsByid(Integer id);
}
