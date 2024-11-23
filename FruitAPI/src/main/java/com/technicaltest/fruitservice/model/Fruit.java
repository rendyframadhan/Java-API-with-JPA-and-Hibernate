package com.technicaltest.fruitservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Table(name = "fruit_list", schema = "fruit_management_service")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Fruit {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fruit_name")
    private String fruitName;

    @Column(name = "is_deleted")
    @JsonProperty("is_deleted")
    private boolean isDeleted;
}
