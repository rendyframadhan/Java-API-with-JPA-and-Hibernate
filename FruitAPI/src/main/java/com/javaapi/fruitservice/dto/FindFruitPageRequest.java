package com.javaapi.fruitservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindFruitPageRequest {

    private Integer pageNumber;
    private Integer sizeData;
    private String sortBy;
    private String direction;
}
