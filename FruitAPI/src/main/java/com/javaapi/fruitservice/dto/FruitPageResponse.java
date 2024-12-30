package com.javaapi.fruitservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FruitPageResponse implements Serializable {

    private List<FruitPageList> fruitPageList;
    private String pageNumber;
    private String totalPage;

}
