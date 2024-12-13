package com.javaapi.fruitservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BaseResponseDto<T> implements Serializable {

    private String responseCode;
    private String status;
    private String message;
    private transient T data;
}
