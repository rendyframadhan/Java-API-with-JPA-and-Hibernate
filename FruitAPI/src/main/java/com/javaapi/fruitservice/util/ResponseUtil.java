package com.javaapi.fruitservice.util;

import com.javaapi.fruitservice.dto.BaseResponseDto;

public class ResponseUtil {

    private ResponseUtil(){

    }

    public static <T> BaseResponseDto<T> constructBaseResponse(T data) {
        BaseResponseDto<T> baseResponse = new BaseResponseDto<>();
        baseResponse.setResponseCode("00");
        baseResponse.setStatus("Success");
        baseResponse.setMessage("Success");
        baseResponse.setData(data);
        return baseResponse;
    }

    public static <T> BaseResponseDto<T> constructErrorResponse(String errorMessage) {
        BaseResponseDto<T> baseResponse = new BaseResponseDto<>();
        baseResponse.setResponseCode("99");
        baseResponse.setStatus("Failed");
        baseResponse.setMessage(errorMessage);
        baseResponse.setData(null);
        return baseResponse;
    }
}
