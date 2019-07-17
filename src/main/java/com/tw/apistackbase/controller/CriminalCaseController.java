package com.tw.apistackbase.controller;

import com.tw.apistackbase.entity.CriminalCase;
import com.tw.apistackbase.repository.CriminalCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cases")
public class CriminalCaseController {
    @Autowired
    private CriminalCaseRepository criminalCaseRepository;
    @PostMapping
    public void saveCase(@RequestBody CriminalCase criminalCase){
        criminalCaseRepository.save(criminalCase);
    }
    @GetMapping
    public List<CriminalCase> saveCase(){
        return criminalCaseRepository.findAll();
    }

}
