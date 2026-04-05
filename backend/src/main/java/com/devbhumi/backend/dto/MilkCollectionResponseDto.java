package com.devbhumi.backend.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class MilkCollectionResponseDto {

    private Long id;
    private Long supplierId;
    private String supplierName;
    private BigDecimal quantity;
    private BigDecimal fat;
    private BigDecimal snf;
    private BigDecimal rate;
    private BigDecimal totalAmount;
    private LocalDate collectionDate;
    private String shift;
}