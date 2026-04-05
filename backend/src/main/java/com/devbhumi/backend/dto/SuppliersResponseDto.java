package com.devbhumi.backend.dto;

import lombok.Data;

@Data
public class SuppliersResponseDto {
    private Long id;
    private String name;
    private String phone;
    private String village;
    private String status;
}
