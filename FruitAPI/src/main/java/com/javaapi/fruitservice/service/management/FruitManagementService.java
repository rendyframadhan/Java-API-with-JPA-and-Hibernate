package com.javaapi.fruitservice.service.management;

import com.javaapi.fruitservice.dto.*;
import com.javaapi.fruitservice.model.Fruit;
import com.javaapi.fruitservice.repository.FruitRepository;
import com.javaapi.fruitservice.util.ResponseUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
@SuppressWarnings("all")
public class FruitManagementService {

    private final FruitRepository fruitRepository;
    private  final EntityManager entityManager;
    private static final String FRUIT_NAME = "fruitName";
    private static final String IS_DELETED = "isDeleted";
    private static final String ALL = "ALL";

    public List<Fruit> getFruitList(){
        List<Fruit> list = new ArrayList<>();
        try {
            list = fruitRepository.findAll();
        } catch (Exception e){
            log.error("Error when Get Fruit List", e);
        }

        return list;
    }

    public FruitBaseResponse insertFruit(StoreFruitRequest request){
        FruitBaseResponse response = null;
        try {
            Fruit fruit = Fruit.builder()
                    .fruitName(request.getFruitName())
                    .build();
            Fruit save = fruitRepository.saveAndFlush(fruit);

            response = FruitBaseResponse.builder()
                    .status("Success")
                    .responseCode("00")
                    .message("Fruit Saved Successfully with name " + save.getFruitName())
                    .build();
        } catch (Exception e){
            log.error("Error when Store Fruit Name", e);
            throw e;
        }

        return response;
    }

    public FruitBaseResponse updateFruit(UpdateFruitRequest request){
        FruitBaseResponse response = null;
        Fruit updatedFruit = null;
        try {
            Optional<Fruit> fruit = fruitRepository.findById(request.getId());
            if (fruit.isPresent()){
                updatedFruit = fruit.get();
                updatedFruit.setFruitName(request.getFruitName());
                updatedFruit.setDeleted(false);

                updatedFruit = fruitRepository.saveAndFlush(updatedFruit);

                response = FruitBaseResponse.builder()
                        .status("Success")
                        .responseCode("00")
                        .message("Fruit Updated Successfully with name " + updatedFruit.getFruitName())
                        .build();
            }
        } catch (Exception e){
            log.error("Error when Update Fruit List", e);
            throw e;
        }

        return response;
    }

    public FruitBaseResponse deleteFruit(DeleteFruitRequest request){
        FruitBaseResponse response = null;
        Fruit deletedFruit = null;
        try {
            Optional<Fruit> fruit = fruitRepository.findById(request.getId());
            if (fruit.isPresent()){
                deletedFruit = fruit.get();
                deletedFruit.setDeleted(true);

                deletedFruit = fruitRepository.saveAndFlush(deletedFruit);

                response = FruitBaseResponse.builder()
                        .status("Success")
                        .responseCode("00")
                        .message("Fruit Deleted Successfully with name " + deletedFruit.getFruitName())
                        .build();
            }
        } catch (Exception e){
            log.error("Error when Delete Fruit", e);
            throw e;
        }

        return response;
    }

    public  BaseResponseDto<List<FruitResponseDto>> getAllFruit(GetFruitRequest request){
        BaseResponseDto<List<FruitResponseDto>> response = new BaseResponseDto<>();
        List<Fruit> fruit;
        try {
            fruit = findFruit(request.getFruitName());
            List<FruitResponseDto> fruitList = fruit.stream()
                    .map(fruits -> new FruitResponseDto(fruits.getId(), fruits.getFruitName()))
                    .distinct()
                    .collect(Collectors.toList());

            response = ResponseUtil.constructBaseResponse(fruitList);
        } catch (Exception e){
            log.error("Error when getAllFruit", e);
            return ResponseUtil.constructErrorResponse("Failed to retrieve fruits: " + e.getMessage());
        }

        return response;
    }

    public List<Fruit> findFruit(String fruitName) {
        // Get CriteriaBuilder from Entity Manager
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        // Create Criteria Query From Fruit Model
        CriteriaQuery<Fruit> query = cb.createQuery(Fruit.class);
        Root<Fruit> root = query.from(Fruit.class);

        // construct Predicate where is deleted equals false
        Predicate predicate = cb.equal(root.get(IS_DELETED), false);

        if (!ALL.equalsIgnoreCase(fruitName)) {
            predicate = cb.and(predicate, cb.equal(root.get(FRUIT_NAME), fruitName));
        }

        // Build the query with the constructed predicate
        query.select(root)
                .where(predicate)
                .orderBy(cb.asc(root.get(FRUIT_NAME)));

        // Execute the query and return the result
        return entityManager.createQuery(query).getResultList();
    }

}
