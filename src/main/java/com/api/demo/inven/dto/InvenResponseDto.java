package com.api.demo.inven.dto;

import com.api.demo.inven.domain.Inven;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
public class InvenResponseDto {
    @Schema(description = "상품명")
    private String prdNm;

    @Schema(description = "옵션명")
    private String optnNm;

    @Schema(description = "재고수량")
    private int prdQnty;

    public InvenResponseDto(Inven inven) {
        this.prdNm = inven.getPrdNm();
        this.optnNm = inven.getOptnNm();
        this.prdQnty = inven.getPrdQnty();
    }
}
