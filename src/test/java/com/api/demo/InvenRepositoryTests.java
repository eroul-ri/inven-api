package com.api.demo;

import com.api.demo.inven.domain.Inven;
import com.api.demo.inven.dto.InvenRequestDto;
import com.api.demo.inven.repository.InvenRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class InvenRepositoryTests {
    @Autowired
    private InvenRepository invenRepository;

    @Before
    @Sql(scripts = {"classpath:data.sql"})
    public void setUpBefore() {
        log.info("data.sql executed...");
    }

    public Inven getEntity(String prdNm, String optnNm) {
        InvenRequestDto invenRequestDto = new InvenRequestDto(prdNm, optnNm);

        return invenRequestDto.toEntity(invenRequestDto);
    }

    @Test
    public void findByPrdNmTest() {
        Inven inven = getEntity("prd-a", null);

        List<Inven> invens = invenRepository.findByPrdNm(inven.getPrdNm());

        log.info(" findByPrdNm  : {}", invens);

        Assert.notNull(invens, "Invens is Null");
    }

    @Test
    public void findByPrdNmAndOptnNmTest() {
        Inven inven = getEntity("prd-a", "opt-aa");

        List<Inven> invens = invenRepository.findByPrdNmAndOptnNm(inven.getPrdNm(), inven.getOptnNm());

        log.info(" findByPrdNmAndOptnNm  : {}", invens);

        Assert.notNull(invens, "Invens is Null");
    }
}
