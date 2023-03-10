package com.api.demo;

import com.api.demo.inven.domain.Inven;
import com.api.demo.inven.dto.InvenRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void invenRequestToEntity() {
        InvenRequestDto invenRequestDto = new InvenRequestDto("prd-a", null, 0);

        Inven inven = invenRequestDto.toEntity();

        Assert.assertEquals(invenRequestDto.getPrdNm(), inven.getPrdNm());
    }
}
