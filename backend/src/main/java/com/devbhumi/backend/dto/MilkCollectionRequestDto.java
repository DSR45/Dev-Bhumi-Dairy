package com.devbhumi.backend.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class MilkCollectionRequestDto {

    @NotNull(message = "Supplier ID is required")
    private Long supplierId;

    @NotNull(message = "Quantity is required")
    @DecimalMin(value = "0.1", message = "Quantity must be greater than 0")
    private BigDecimal quantity;

    @DecimalMin(value = "0.0", message = "Fat cannot be negative")
    @DecimalMax(value = "15.0", message = "Fat seems unrealistic")
    private BigDecimal fat;

    @DecimalMin(value = "0.0", message = "SNF cannot be negative")
    @DecimalMax(value = "15.0", message = "SNF seems unrealistic")
    private BigDecimal snf;

    @NotNull(message = "Price per liter is required")
    @DecimalMin(value = "1.0", message = "Price must be greater than 0")
    private BigDecimal rate;

    @NotNull(message = "Collection date is required")
    private LocalDate collectionDate;

    @Pattern(regexp = "morning|evening", message = "Shift must be morning or evening")
    private String shift;
}