package com.devbhumi.backend.service;

import com.devbhumi.backend.Exception.DailySummaryAlreadyExistsException;
import com.devbhumi.backend.Exception.DailySummaryNotFoundException;
import com.devbhumi.backend.dto.DailySummaryResponseDto;
import com.devbhumi.backend.entity.DailySummary;
import com.devbhumi.backend.entity.MilkCollection;
import com.devbhumi.backend.mapper.DailySummaryMapper;
import com.devbhumi.backend.repository.DailySummaryRepository;
import com.devbhumi.backend.repository.MilkCollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DailySummaryService {

    @Autowired
    private DailySummaryRepository dailySummaryRepository;

    @Autowired
    private MilkCollectionRepository milkCollectionRepository;

    @Autowired
    private DailySummaryMapper dailySummaryMapper;

    public DailySummaryResponseDto generateSummary(LocalDate date) {
        Optional<DailySummary> existing = dailySummaryRepository.findBySummaryDate(date);
        if (existing.isPresent()) {
            throw new DailySummaryAlreadyExistsException("Summary already exists for date: " + date);
        }

        List<MilkCollection> collections = milkCollectionRepository.findByCollectionDate(date);
        if (collections.isEmpty()) {
            // Create empty summary
            DailySummary summary = new DailySummary();
            summary.setSummaryDate(date);
            summary.setTotalMilk(BigDecimal.ZERO);
            summary.setTotalAmount(BigDecimal.ZERO);
            summary.setAvgFat(BigDecimal.ZERO);
            DailySummary saved = dailySummaryRepository.save(summary);
            return dailySummaryMapper.toDto(saved);
        }

        BigDecimal totalMilk = collections.stream()
                .map(MilkCollection::getQuantity)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalAmount = collections.stream()
                .map(MilkCollection::getTotalAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        // Weighted average fat
        BigDecimal weightedFatSum = collections.stream()
                .map(c -> c.getQuantity().multiply(c.getFat()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal avgFat = totalMilk.compareTo(BigDecimal.ZERO) > 0 ?
                weightedFatSum.divide(totalMilk, 2, RoundingMode.HALF_UP) : BigDecimal.ZERO;

        DailySummary summary = new DailySummary();
        summary.setSummaryDate(date);
        summary.setTotalMilk(totalMilk);
        summary.setTotalAmount(totalAmount);
        summary.setAvgFat(avgFat);

        DailySummary saved = dailySummaryRepository.save(summary);
        return dailySummaryMapper.toDto(saved);
    }

    public List<DailySummaryResponseDto> getAll() {
        List<DailySummary> summaries = dailySummaryRepository.findAll();
        return summaries.stream()
                .map(dailySummaryMapper::toDto)
                .collect(Collectors.toList());
    }

    public DailySummaryResponseDto getById(Long id) {
        DailySummary summary = dailySummaryRepository.findById(id)
                .orElseThrow(() -> new DailySummaryNotFoundException("Daily summary not found with id: " + id));
        return dailySummaryMapper.toDto(summary);
    }

    public DailySummaryResponseDto getByDate(LocalDate date) {
        DailySummary summary = dailySummaryRepository.findBySummaryDate(date)
                .orElseThrow(() -> new DailySummaryNotFoundException("Daily summary not found for date: " + date));
        return dailySummaryMapper.toDto(summary);
    }

    public void delete(Long id) {
        DailySummary summary = dailySummaryRepository.findById(id)
                .orElseThrow(() -> new DailySummaryNotFoundException("Daily summary not found with id: " + id));
        dailySummaryRepository.delete(summary);
    }
}
