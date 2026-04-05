package com.devbhumi.backend.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Suppliers")
public class Suppliers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String name;

    private String phone;
    @Column(nullable = false)
    private String village;
    
    @Column(name="created_at",updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "status",nullable = false)
    private  String status="ACTIVE";

    @PrePersist
    protected void onCreate(){
        this.createdAt=LocalDateTime.now();
    }
    @PostPersist
    protected void afterCreate(){
        System.out.println("Supplier created");
    }
}
