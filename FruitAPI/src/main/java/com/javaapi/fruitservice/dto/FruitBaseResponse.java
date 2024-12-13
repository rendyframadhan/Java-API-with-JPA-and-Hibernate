package com.javaapi.fruitservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FruitBaseResponse {

    private String status;
    private String responseCode;
    private String message;

}
