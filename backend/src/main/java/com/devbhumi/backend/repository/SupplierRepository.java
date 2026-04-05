package com.devbhumi.backend.repository;

import com.devbhumi.backend.entity.Suppliers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Suppliers,Long> {

    List<Suppliers> findByStatus(String status);
}
