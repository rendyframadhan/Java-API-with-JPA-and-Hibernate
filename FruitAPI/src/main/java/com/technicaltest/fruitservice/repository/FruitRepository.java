package com.technicaltest.fruitservice.repository;

import com.technicaltest.fruitservice.model.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FruitRepository extends JpaRepository<Fruit, Long> {
    Optional<Fruit> findByIdAndIsDeleted(Long id, boolean isDeleted);

}
