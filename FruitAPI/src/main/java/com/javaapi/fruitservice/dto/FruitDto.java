package com.javaapi.fruitservice.dto;

import com.javaapi.fruitservice.model.Fruit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FruitDto {

    private Fruit fruit;
}
