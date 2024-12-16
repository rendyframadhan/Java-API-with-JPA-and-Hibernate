package com.javaapi.fruitservice.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(of = "fruitName") // If you don't Specific it to fruitName, the response still return same fruitName because the id is unique
public class FruitResponseDto {

    private Long id;
    private String fruitName;
}
