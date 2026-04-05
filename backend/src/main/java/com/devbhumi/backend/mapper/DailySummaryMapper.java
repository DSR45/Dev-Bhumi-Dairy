package com.devbhumi.backend.mapper;
import com.devbhumi.backend.dto.DailySummaryResponseDto;
import com.devbhumi.backend.entity.DailySummary;
import org.springframework.stereotype.Component;

@Component
public class DailySummaryMapper {

    public DailySummaryResponseDto toDto(DailySummary entity) {


        DailySummaryResponseDto dto = new DailySummaryResponseDto();
        dto.setId(entity.getId());
        dto.setSummaryDate(entity.getSummaryDate());
        dto.setTotalMilk(entity.getTotalMilk());
        dto.setTotalAmount(entity.getTotalAmount());
        dto.setAvgFat(entity.getAvgFat());
        dto.setCreatedAt(entity.getCreatedAt());
        return dto;
    }

}