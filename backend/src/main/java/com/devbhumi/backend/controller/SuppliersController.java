package com.devbhumi.backend.controller;

import com.devbhumi.backend.dto.SuppliersRequestDto;
import com.devbhumi.backend.dto.SuppliersResponseDto;
import com.devbhumi.backend.service.SuppliersService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/supplier/")
public class SuppliersController {
    @Autowired
    SuppliersService suppliersService;
    @PostMapping("/create")
    public ResponseEntity<String> CreateSupplier(@Valid @RequestBody SuppliersRequestDto dto){
        suppliersService.create(dto);
        return ResponseEntity.ok().body("Created");
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<SuppliersResponseDto>> getAll(){
        return ResponseEntity.ok().body(suppliersService.getAll());

    }
    @GetMapping("/find/{id}")
    public ResponseEntity<SuppliersResponseDto> findById(@PathVariable Long id){
       return ResponseEntity.ok().body(suppliersService.getById(id));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<SuppliersResponseDto> update(@Valid @RequestBody SuppliersRequestDto dto,@PathVariable Long id){
        SuppliersResponseDto response=suppliersService.update(id,dto);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        suppliersService.delete(id);
        return ResponseEntity.ok().body("Deleted Successfully");

    }

}
