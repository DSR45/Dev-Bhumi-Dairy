package com.devbhumi.backend.service;

import com.devbhumi.backend.Exception.MilkCollectionNotFoundException;
import com.devbhumi.backend.Exception.SupplierNotFoundException;
import com.devbhumi.backend.dto.MilkCollectionRequestDto;
import com.devbhumi.backend.dto.MilkCollectionResponseDto;
import com.devbhumi.backend.entity.MilkCollection;
import com.devbhumi.backend.entity.Suppliers;
import com.devbhumi.backend.mapper.MilkCollectionMapper;
import com.devbhumi.backend.repository.MilkCollectionRepository;
import com.devbhumi.backend.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MilkCollectionService {

    @Autowired
    private MilkCollectionRepository milkCollectionRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private MilkCollectionMapper milkCollectionMapper;

    public MilkCollectionResponseDto create(MilkCollectionRequestDto dto) {
        Suppliers supplier = supplierRepository.findById(dto.getSupplierId())
                .orElseThrow(() -> new SupplierNotFoundException("Supplier not found with id: " + dto.getSupplierId()));

        MilkCollection entity = milkCollectionMapper.toEntity(dto, supplier);
        MilkCollection saved = milkCollectionRepository.save(entity);
        return milkCollectionMapper.toDto(saved);
    }

    public List<MilkCollectionResponseDto> getAll() {
        List<MilkCollection> entities = milkCollectionRepository.findAll();
        return entities.stream()
                .map(milkCollectionMapper::toDto).toList();
    }

    public MilkCollectionResponseDto update(Long id, MilkCollectionRequestDto dto) {
        MilkCollection entity = milkCollectionRepository.findById(id)
                .orElseThrow(() -> new MilkCollectionNotFoundException("Milk collection not found with id: " + id));

        Suppliers supplier = supplierRepository.findById(dto.getSupplierId())
                .orElseThrow(() -> new SupplierNotFoundException("Supplier not found with id: " + dto.getSupplierId()));

        entity.setSupplier(supplier);
        entity.setQuantity(dto.getQuantity());
        entity.setFat(dto.getFat());
        entity.setSnf(dto.getSnf());
        entity.setRate(dto.getRate());
        entity.setTotalAmount(dto.getQuantity().multiply(dto.getRate()));
        entity.setCollectionDate(dto.getCollectionDate());
        entity.setShift(dto.getShift());

        MilkCollection updated = milkCollectionRepository.save(entity);
        return milkCollectionMapper.toDto(updated);
    }

    public void delete(Long id) {
        MilkCollection entity = milkCollectionRepository.findById(id)
                .orElseThrow(() -> new MilkCollectionNotFoundException("Milk collection not found with id: " + id));
        milkCollectionRepository.delete(entity);
    }

    public MilkCollectionResponseDto getById(Long id) {
        MilkCollection entity = milkCollectionRepository.findById(id)
                .orElseThrow(() -> new MilkCollectionNotFoundException("Milk collection not found with id: " + id));
        return milkCollectionMapper.toDto(entity);
    }
}
