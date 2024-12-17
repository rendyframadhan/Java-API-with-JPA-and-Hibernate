package com.javaapi.fruitservice.repository;

import com.javaapi.fruitservice.model.Fruit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FruitRepository extends JpaRepository<Fruit, Long> {
    Optional<Fruit> findByIdAndIsDeleted(Long id, boolean isDeleted);

    Page<Fruit> findByIsDeleted(Pageable pageable, boolean isDeleted);

}
