package com.example.practice.practice1.entity;

import com.example.practice.practice1.entity.Student;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Builder
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String laptopName;
    private String modelNum;

//    @OneToOne
//    private Student student;
}
