package com.devbhumi.backend.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Milk_Collection",uniqueConstraints = @UniqueConstraint(columnNames = {"supplier_id","collection_date","shift"}))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MilkCollection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch =FetchType.LAZY )
    @JoinColumn(name ="supplier_id",nullable = false)
    private Suppliers supplier;

    @Column(nullable = false,precision = 6,scale = 2)
    private BigDecimal quantity;
    @Column(nullable = false,scale = 2,precision = 4)
    private BigDecimal fat;
    @Column(nullable = false,precision = 4,scale = 2)
    private  BigDecimal snf;
    @Column(name = "rate", nullable = false, precision = 6, scale = 2)
    private BigDecimal rate;

    @Column(name = "total_amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal totalAmount;

    @Column(name = "collection_date", nullable = false)
    private LocalDate collectionDate;

    private String shift; // morning / evening

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

}
