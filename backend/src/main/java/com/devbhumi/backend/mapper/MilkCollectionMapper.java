package com.devbhumi.backend.mapper;

import com.devbhumi.backend.dto.MilkCollectionRequestDto;
import com.devbhumi.backend.dto.MilkCollectionResponseDto;
import com.devbhumi.backend.entity.MilkCollection;
import com.devbhumi.backend.entity.Suppliers;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Component
public class MilkCollectionMapper {


    public MilkCollection toEntity(MilkCollectionRequestDto dto, Suppliers supplier){

        MilkCollection entity=new MilkCollection();

        entity.setSupplier(supplier);
        entity.setQuantity(dto.getQuantity());
        entity.setFat(dto.getFat());
        entity.setSnf(dto.getSnf());
        entity.setRate(dto.getRate());
        entity.setSnf(dto.getSnf());
        entity.setCollectionDate(dto.getCollectionDate());
        entity.setShift(dto.getShift());

        if(dto.getQuantity()!=null && dto.getRate()!=null){
            BigDecimal total=dto.getQuantity().multiply(dto.getRate());
            entity.setTotalAmount(total);
        }


        return entity;
    }

    public MilkCollectionResponseDto toDto(MilkCollection entity){
        MilkCollectionResponseDto dto=new MilkCollectionResponseDto();

        dto.setQuantity(entity.getQuantity());
        dto.setRate(entity.getRate());
        dto.setFat(entity.getFat());
        dto.setSnf(entity.getSnf());
        dto.setTotalAmount(entity.getTotalAmount());
        dto.setSupplierId(entity.getSupplier().getId());
        dto.setShift(entity.getShift());
        dto.setId(entity.getId());
        dto.setCollectionDate(entity.getCollectionDate());
        dto.setSupplierName(entity.getSupplier().getName());
        return dto;


    }
}
