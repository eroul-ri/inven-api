package com.api.demo.common;

import lombok.Getter;

@Getter
public class CommRespDto<T> {
    private String code;
    private String message;
    private T contents;

    public CommRespDto(String code, String message, T contents) {
        this.code = code;
        this.message = message;
        this.contents = contents;
    }

    /**
     * 성공응답 with contents
     * @param contents 응답컨텐츠
     * @return
     */
    public  CommRespDto<T> successWithContents(T contents) {
        return new CommRespDto<T>(CommCode.SUCCESS.getCode(), CommCode.SUCCESS.getMessage(), contents);
    }

    /**
     * 성공응답
     * @return
     */
    public  CommRespDto<T> successNoContents() {
        return new CommRespDto<>(CommCode.SUCCESS.getCode(), CommCode.SUCCESS.getMessage(), null);
    }

    /**
     * 실패응답
     * @return
     */
    public  CommRespDto<T> fail() {
        return new CommRespDto<>(CommCode.FAIL.getCode(), CommCode.FAIL.getMessage(), null);
    }


}
