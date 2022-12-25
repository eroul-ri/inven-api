package com.api.demo.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CommCode {
    SUCCESS("0000", "성공")
    , FAIL("0001", "실패")
    , ERROR("0002", "에러")
    , BADREQUEST("0003", "잘못된 요청입니다.\n요청 정보를 다시 확인해주세요.")
    , NOTFOUND("0004", "요청한 정보를 찾을 수 없습니다.");

    private String code;
    private String message;
}
