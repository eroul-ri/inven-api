package com.api.demo.inven.dto;

import com.api.demo.inven.domain.Inven;
import lombok.Getter;

@Getter
public class InvenRequestDto {
    private String prdNm;
    private String optnNm;

    private int prdQnty;

    public InvenRequestDto(String prdNm, String optnNm) {
        this.prdNm = prdNm;
        this.optnNm = optnNm;
    }

    public Inven toEntity(InvenRequestDto invenRequestDto) {
        return Inven.builder()
                    .prdNm(invenRequestDto.getPrdNm())
                    .optnNm(invenRequestDto.getOptnNm())
                    .prdQnty(invenRequestDto.getPrdQnty())
                    .build();
    }
}
