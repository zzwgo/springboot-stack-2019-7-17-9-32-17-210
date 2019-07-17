package com.tw.apistackbase.entity;
import com.tw.apistackbase.repository.CriminalCaseRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CriminalCaseTest {
    @Autowired
    private CriminalCaseRepository criminalCaseRepository;

    @Test
    public void should_throw_exception_when_save_null() {
        CriminalCase criminalCase = new CriminalCase();
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
    public void should_return_exception_when_give_a_id() {
        CriminalCase criminalCase=criminalCaseRepository.findById("402881496c002806016c002978820000").orElse(null);
        assertEquals("dark",criminalCase.getName());
    }
}