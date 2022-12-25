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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class InvenRepositoryTests {
    @Autowired
    private InvenRepository invenRepository;

    String prdNm = "prd-a";
    String optnNm = "opt-aa";

    @Before
    @Sql(scripts = {"classpath:data.sql"})
    public void setUpBefore() {
        log.info("data.sql executed...");
    }

    public Inven getEntity(String prdNm, String optnNm) {
        InvenRequestDto invenRequestDto = new InvenRequestDto(prdNm, optnNm, 0);

        return invenRequestDto.toEntity();
    }

    /**
     * 상품명 조회
     */
    @Test
    public void findByPrdNmTest() {
        Inven inven = getEntity(prdNm, null);

        List<Inven> invens = invenRepository.findByPrdNm(inven.getPrdNm());

        log.info(" findByPrdNm  : {}", invens);

        Assert.notNull(invens, "Invens is Null");
    }

    /**
     * 상품명 + 옵션명 조회
     */
    @Test
    public void findByPrdNmAndOptnNmTest() {
        Inven inven = getEntity(prdNm, optnNm);

        Optional<Inven> item = invenRepository.findByPrdNmAndOptnNm(inven.getPrdNm(), inven.getOptnNm());

        Assert.notNull(item, "Item is Null");
    }

    /**
     * 재고수량 증/차감
     * @throws Exception
     */
    @Test
    public void updateTest() throws Exception {
        Inven inven = getEntity(prdNm, optnNm);

        Optional<Inven> item = invenRepository.findByPrdNmAndOptnNm(inven.getPrdNm(), inven.getOptnNm());

        Inven result = item.orElse(null);

        int qnty = 10;

        Inven updateResult = setInvenQnty(result, qnty);
        Assert.isTrue(qnty == updateResult.getPrdQnty(), "재고수량이 저장되지 않았습니다.");
    }

    @Transactional
    public Inven setInvenQnty(Inven result, int qnty) throws Exception {
        if(!result.psblQntyUpdate(qnty)) {
            log.error(" impossibleQntyUpdate  : {}", result);
            throw new Exception();
        }
        result.addQnty(qnty);

        return result;
    }
}
