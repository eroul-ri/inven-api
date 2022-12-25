package com.api.demo.common;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.util.Strings;

@Getter
public class CommRespDto<T> {
    @Schema(description = "공통 코드")
    private String code;
    @Schema(description = "메시지")
    private String message;

    @Schema(description = "응답 데이터")
    private T contents;

    public CommRespDto(String code, String message, T contents) {
        this.code = code;
        this.message = message;
        this.contents = contents;
    }

    public CommRespDto(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 성공 응답 with contents
     * @param contents 응답컨텐츠
     * @return
     */
    public static <T> CommRespDto<T> successWithContents(T contents) {
        return new CommRespDto<>(CommCode.SUCCESS.getCode(), CommCode.SUCCESS.getMessage(), contents);
    }

    /**
     * 성공 응답 no contents
     * @return
     */
    public static CommRespDto successNoContents() {
        return new CommRespDto<>(CommCode.SUCCESS.getCode(), CommCode.SUCCESS.getMessage());
    }

    /**
     * 실패 응답
     * @return
     */
    public static CommRespDto fail(String message) {
        if(StringUtils.isEmpty(message)) {
            message = CommCode.FAIL.getMessage();
        }
        return new CommRespDto<>(CommCode.FAIL.getCode(), message);
    }

    /**
     * 찾을 수 없음
     * @return
     */
    public static CommRespDto notFound() {
        return new CommRespDto<>(CommCode.NOTFOUND.getCode(), CommCode.NOTFOUND.getMessage());
    }

    /**
     * 잘못된 요청 처리
     * @return
     */
    public static CommRespDto badRequest(String message) {
        if(Strings.isEmpty(message)) {
            message = CommCode.BADREQUEST.getMessage();
        }
        return new CommRespDto<>(CommCode.BADREQUEST.getCode(), message);
    }

    /**
     * 에러 처리
     * @return
     */
    public static CommRespDto error(String message) {
        return new CommRespDto<>(CommCode.ERROR.getCode(), message);
    }

}
