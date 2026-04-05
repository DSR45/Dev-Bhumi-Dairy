package com.devbhumi.backend.mapper;

import com.devbhumi.backend.dto.SuppliersRequestDto;
import com.devbhumi.backend.dto.SuppliersResponseDto;
import com.devbhumi.backend.entity.Suppliers;
import org.springframework.stereotype.Component;

@Component
public class SuppliersMapper {

    public Suppliers toEntity(SuppliersRequestDto dto){
        Suppliers entity=new Suppliers();
        entity.setName(dto.getName());
        entity.setPhone(dto.getPhone());
        entity.setStatus(dto.getStatus());
        entity.setVillage(dto.getVillage());
        return entity;
    }

    public SuppliersResponseDto toDto(Suppliers entity){
        SuppliersResponseDto dto=new SuppliersResponseDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setPhone(entity.getPhone());
        dto.setVillage(entity.getVillage());
        dto.setStatus(entity.getStatus());
        return dto;
    }
}
