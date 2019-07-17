package com.tw.apistackbase.entity;
import com.tw.apistackbase.repository.CriminalCaseRepository;
import com.tw.apistackbase.repository.ProcuratorateRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProcuratorateTest {
    @Autowired
    private ProcuratorateRepository procuratorateRepository;


    @Test
    public void should_Procuratorate_contain_Prosecutor() {
        Procuratorate procuratorate = new Procuratorate("检察院1");
        Prosecutor prosecutor1 = new Prosecutor("印度阿三1");
        Prosecutor prosecutor2 = new Prosecutor("印度阿三2");
        procuratorate.setProsecutors(Arrays.asList(prosecutor1,prosecutor2));
        Procuratorate result = procuratorateRepository.saveAndFlush(procuratorate);
        assertTrue(result.getProsecutors().size() > 1);
    }


}