package com.devbhumi.backend.repository;

import com.devbhumi.backend.entity.MilkCollection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MilkCollectionRepository extends JpaRepository<MilkCollection,Long> {

    List<MilkCollection> findByCollectionDate(LocalDate collectionDate);
}
