package com.tw.apistackbase.repository;

import com.tw.apistackbase.entity.CriminalCase;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CriminalCaseRepository extends JpaRepository<CriminalCase,String> {
    @Query(value = "SELECT c FROM CriminalCase c order by c.time desc")
    List<CriminalCase> findCaseByTimeDesc();
}
