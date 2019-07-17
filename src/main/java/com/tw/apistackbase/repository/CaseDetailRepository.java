package com.tw.apistackbase.repository;

import com.tw.apistackbase.entity.CriminalCaseDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaseDetailRepository extends JpaRepository<CriminalCaseDetail,String> {

}
