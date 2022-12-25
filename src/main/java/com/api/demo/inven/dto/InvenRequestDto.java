package com.api.demo.inven.dto;

import com.api.demo.inven.domain.Inven;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import org.apache.logging.log4j.util.Strings;

import javax.validation.constraints.*;

@Getter
public class InvenRequestDto {
    @Schema(description = "상품명")
    @Size(min = 2, max = 100)
    private String prdNm;

    @Schema(description = "옵션명")
    @Size(min = 2, max = 100)
    private String optnNm;

    @Min(1) @Max(Integer.MAX_VALUE)
    @Schema(description = "재고수량")
    private int prdQnty;

    public InvenRequestDto(String prdNm, String optnNm, int prdQnty) {
        this.prdNm = prdNm;
        this.optnNm = optnNm;
        this.prdQnty = prdQnty;
    }

     public boolean validRequestDto(String prdNm) {
        return Strings.isNotEmpty(this.prdNm) && Strings.isNotEmpty(optnNm)
                                         && prdQnty > 0 && prdNm.equals(this.prdNm);
    }

    public Inven toEntity() {
        return Inven.builder()
                    .prdNm(this.prdNm)
                    .optnNm(this.optnNm)
                    .prdQnty(this.prdQnty)
                    .build();
    }
}
