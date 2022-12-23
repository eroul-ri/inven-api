package com.api.demo.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CommCode {
    SUCCESS("0000", "성공")
    , FAIL("0001", "실패");

    private String code;
    private String message;
}
