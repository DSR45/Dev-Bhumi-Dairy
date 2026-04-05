package com.devbhumi.backend.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class DailySummaryResponseDto {

    private Long id;
    private LocalDate summaryDate;
    private BigDecimal totalMilk;
    private BigDecimal totalAmount;
    private BigDecimal avgFat;
    private LocalDateTime createdAt;
}
