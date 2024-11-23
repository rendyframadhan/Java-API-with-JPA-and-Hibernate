package com.technicaltest.fruitservice.service.management;

import com.technicaltest.fruitservice.dto.DeleteFruitRequest;
import com.technicaltest.fruitservice.dto.FruitBaseResponse;
import com.technicaltest.fruitservice.dto.StoreFruitRequest;
import com.technicaltest.fruitservice.dto.UpdateFruitRequest;
import com.technicaltest.fruitservice.model.Fruit;
import com.technicaltest.fruitservice.repository.FruitRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class FruitManagementService {

    private final FruitRepository fruitRepository;

    public List<Fruit> getFruitList(){
        List<Fruit> list = new ArrayList<>();
        try {
            list = fruitRepository.findAll();
        } catch (Exception e){
            log.error("Error when Get Fruit List");
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
            log.error("Error when Store Fruit Name");
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
            log.error("Error when Update Fruit List");
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
            log.error("Error when Delete Fruit");
            throw e;
        }

        return response;
    }

}
