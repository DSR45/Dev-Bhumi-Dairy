package com.devbhumi.backend.controller;

import com.devbhumi.backend.dto.MilkCollectionRequestDto;
import com.devbhumi.backend.dto.MilkCollectionResponseDto;
import com.devbhumi.backend.service.MilkCollectionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/milk-collection/")
public class MilkCollectionController {

    @Autowired
    private MilkCollectionService milkCollectionService;

    @PostMapping("/create")
    public ResponseEntity<MilkCollectionResponseDto> create(@Valid @RequestBody MilkCollectionRequestDto dto) {
        MilkCollectionResponseDto response = milkCollectionService.create(dto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<MilkCollectionResponseDto>> getAll() {
        List<MilkCollectionResponseDto> responses = milkCollectionService.getAll();
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<MilkCollectionResponseDto> findById(@PathVariable Long id) {
        MilkCollectionResponseDto response = milkCollectionService.getById(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<MilkCollectionResponseDto> update(@PathVariable Long id, @Valid @RequestBody MilkCollectionRequestDto dto) {
        MilkCollectionResponseDto response = milkCollectionService.update(id, dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        milkCollectionService.delete(id);
        return ResponseEntity.ok("Deleted Successfully");
    }
}
