package com.api.demo.inven.controller;

import com.api.demo.common.BadRequestException;
import com.api.demo.common.CommRespDto;
import com.api.demo.inven.dto.InvenRequestDto;
import com.api.demo.inven.dto.InvenResponseDto;
import com.api.demo.inven.service.InvenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.webjars.NotFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Size;
import java.util.List;

@Tag(name = "Inven", description = "재고 관리 api")
@RestController
@RequestMapping("/api")
public class InvenController {
    private final InvenService invenService;

    private InvenController(InvenService invenService) {
        this.invenService = invenService;
    }

    /**
     * 재고 현황 조회
     * #1
     * - in: 상품명
     * - out: 전달받은 상품명에 해당하는 옵션별 재고수량
     * #2
     * - in: 상품명 + 옵션명
     * - out: 전달받은 상품명 + 옵션명 조합에 해당하는 재고수량
     * @param prdNm 상품명
     * @param optnNm 옵션명
     * @return
     */
    @Operation(summary = "재고 현황 조회")
    @GetMapping("/inven/{prdNm}")
    public ResponseEntity<CommRespDto<List<InvenResponseDto>>> readPrdInven(@PathVariable @Size(min = 2, max = 100) String prdNm
                                                                            , @RequestParam(required = false) String optnNm) {
        List<InvenResponseDto> responseDtos = invenService.readPrdOptnInven(prdNm, optnNm);

        if(responseDtos.isEmpty()) {
            throw new NotFoundException(StringUtils.EMPTY);
        }

        return ResponseEntity.ok(CommRespDto.successWithContents(responseDtos));
    }

    /**
     * 재고 증/차감 처리
     * increment : 재고 증가 처리 API
     * decrement : 재고 차감 처리 API
     * - in: 상품명 + 옵션명 + 요청수량
     * - out: 적절한 응답 자유구성
     * @param prdNm
     * @param invenRequestDto
     * @return
     */
    @Operation(summary = "재고수량 변경")
    @PutMapping(path = {"/inven/{prdNm}/increment", "/inven/{prdNm}/decrement"})
    public ResponseEntity<CommRespDto<InvenResponseDto>> increasePrdInven(@PathVariable @Size(min = 2, max = 100) String prdNm
                                                                          , @RequestBody InvenRequestDto invenRequestDto
                                                                          , HttpServletRequest request) {
        int increment = request.getRequestURI().contains("/increment") ? 1 : -1;
        if(invenRequestDto == null || !invenRequestDto.validRequestDto(prdNm)) {
            throw new BadRequestException("요청 파라미터가 정확하지 않습니다.\n다시 확인 해주세요.");
        }
        CommRespDto<InvenResponseDto> commRespDto = invenService.modifyPrdOptnInven(invenRequestDto, increment);

        return ResponseEntity.ok(commRespDto);
    }
}
