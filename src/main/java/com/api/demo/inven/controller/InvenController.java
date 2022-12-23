package com.api.demo.inven.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class InvenController {
    /**
     * TODO 1. 재고 현황 조회 API
     *      #1
     *      - in: 상품명
     *      - out: 전달받은 상품명에 해당하는 옵션별 재고수량
     *      #2
     *      - in: 상품명 + 옵션명
     *      - out: 전달받은 상품명 + 옵션명 조합에 해당하는 재고수량
     *      2. 재고 증가 처리 API
     *      - in: 상품명 + 옵션명 + 요청수량
     *      - out: 적절한 응답 자유구성
     *      3. 재고 차감 처리 API
     *      - in: 상품명 + 옵션명 + 요청수량
     *      - out: 적절한 응답 자유구성
     */
}
