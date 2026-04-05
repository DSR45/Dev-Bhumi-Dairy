package com.devbhumi.backend.service;
import com.devbhumi.backend.Exception.SupplierNotFoundException;
import com.devbhumi.backend.dto.SuppliersRequestDto;
import com.devbhumi.backend.dto.SuppliersResponseDto;
import com.devbhumi.backend.entity.Suppliers;
import com.devbhumi.backend.mapper.SuppliersMapper;
import com.devbhumi.backend.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class SuppliersService {
    @Autowired
    SupplierRepository supplierRepo;
    @Autowired
    SuppliersMapper mapper;
    @Autowired
    private ResourcePatternResolver resourcePatternResolver;


    //Insert Supplier into database
    public SuppliersResponseDto create(SuppliersRequestDto dto) {
        if(dto.getStatus()==null){
            dto.setStatus("ACTIVE");
        }
        Suppliers sup=mapper.toEntity(dto);
            Suppliers saved=supplierRepo.save(sup);
            return mapper.toDto(saved);
    }

    //get all list of suppliers from database;
    public List<SuppliersResponseDto> getAll(){
       List<SuppliersResponseDto> dtoList= supplierRepo.findByStatus("ACTIVE").stream().map(mapper::toDto).toList();
    if(dtoList.isEmpty()){
        throw new SupplierNotFoundException("No active supplier found");
    }
    return dtoList;
    }

    //find supplier based on id;
    public SuppliersResponseDto getById(Long id){
           Suppliers response= supplierRepo.findById(id)
                   .orElseThrow(()->new SupplierNotFoundException("Supplier not found with id: "+id));
    return mapper.toDto(response);
    }

    //Update.
    public SuppliersResponseDto update(Long id,SuppliersRequestDto dto){
        Suppliers sup=supplierRepo.findById(id).orElseThrow(()->new SupplierNotFoundException("Supplier not found with id: "+id));
        sup.setName(dto.getName());
        sup.setPhone(dto.getPhone());
        sup.setVillage(dto.getVillage());
        if(dto.getStatus()!=null){
            sup.setStatus(dto.getStatus());
        }
        Suppliers updated=supplierRepo.save(sup);
        return mapper.toDto(updated);
    }

    //delete
    public void delete(Long id){
        Suppliers sup=supplierRepo.findById(id).orElseThrow(()->new SupplierNotFoundException("Supplier not found with id: "+id));
        sup.setStatus("INACTIVE");
        supplierRepo.save(sup);
    }

}
