package com.tw.apistackbase.entity;
import com.tw.apistackbase.repository.CriminalCaseRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CriminalCaseTest {
    @Autowired
    private CriminalCaseRepository criminalCaseRepository;

    @Test
    public void should_throw_exception_when_save_null() {
        CriminalCase criminalCase = new CriminalCase(null,null);
        assertThrows(Exception.class, () ->
                criminalCaseRepository.saveAndFlush(criminalCase));
    }
    @Test
    public void should_throw_exception_when_name_more_than_255() {
        CriminalCase criminalCase = new CriminalCase();
        criminalCase.setName("................................................................................................................................................................................................................................." +
                "........................................................................................................................................................................................................................................" +
                "...............................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................");
        assertThrows(Exception.class, () ->
                criminalCaseRepository.saveAndFlush(criminalCase));
    }

    @Test
    public void should_return_result_by_time_desc() {
        CriminalCase criminalCase1 = new CriminalCase((long) 1000,"dark1");
        CriminalCase criminalCase2 = new CriminalCase((long) 2000,"dark2");
        CriminalCase criminalCase3 = new CriminalCase((long) 3000,"dark3");
        criminalCaseRepository.saveAndFlush(criminalCase1);
        criminalCaseRepository.saveAndFlush(criminalCase2);
        criminalCaseRepository.saveAndFlush(criminalCase3);
        List<CriminalCase> cases = criminalCaseRepository.findCaseByTimeDesc();
        assertEquals("dark3", cases.get(0).getName());
        assertEquals("dark2", cases.get(1).getName());
        assertEquals("dark1", cases.get(2).getName());
    }

    @Test
    public void should_return_result_by_case_name() {
        CriminalCase criminalCase1 = new CriminalCase((long) 1000,"dark1");
        CriminalCase criminalCase2 = new CriminalCase((long) 2000,"dark1");
        criminalCaseRepository.saveAndFlush(criminalCase1);
        criminalCaseRepository.saveAndFlush(criminalCase2);
        List<CriminalCase> cases = criminalCaseRepository.findCaseByName("dark1");
        assertEquals(2,cases.size());
    }

    @Test
    public void should_can_set_detail(){
        CriminalCase criminalCase1 = new CriminalCase((long) 1000,"dark1");
        criminalCase1.setCriminalCaseDetail(new CriminalCaseDetail("abcd","abc"));
        CriminalCase result=criminalCaseRepository.saveAndFlush(criminalCase1);
        assertEquals("abcd",result.getCriminalCaseDetail().getObjective());
    }
}