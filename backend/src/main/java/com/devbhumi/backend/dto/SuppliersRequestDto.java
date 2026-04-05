package com.devbhumi.backend.dto;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class SuppliersRequestDto {
    @NotBlank(message = "name is required")
    @Size(min = 2,max = 100,message = "Name must be between 2-100 characters")
    private  String name;
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone must be 10 digits")
    private  String phone;
    @NotBlank(message = "village name is required")
    private String village;
    @Pattern(regexp = "ACTIVE|INACTIVE", message = "Status must be ACTIVE or INACTIVE")
    private String status;


}
