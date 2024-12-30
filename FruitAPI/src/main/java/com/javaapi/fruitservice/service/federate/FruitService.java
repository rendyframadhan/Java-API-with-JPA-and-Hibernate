package com.javaapi.fruitservice.service.federate;

import com.javaapi.fruitservice.dto.FindFruitPageRequest;
import com.javaapi.fruitservice.dto.FruitPageRequest;
import com.javaapi.fruitservice.dto.FruitPageResponse;
import com.javaapi.fruitservice.dto.PagedResponse;
import com.javaapi.fruitservice.model.Fruit;
import com.javaapi.fruitservice.service.management.FruitManagementService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.javaapi.fruitservice.constant.FruitApiConstant.FRUIT_NAME;

@Slf4j
@RequiredArgsConstructor
@Service
public class FruitService {

    private final FruitManagementService fruitManagementService;

    // TODO
    public FruitPageResponse getFruitPage(FruitPageRequest request){
        try {
            PagedResponse<Fruit> pagedFruit =  fruitManagementService.findFruitPage(FindFruitPageRequest.builder()
                    .pageNumber(request.getPageNumber())
                    .sizeData(5)
                    .sortBy(FRUIT_NAME)
                    .build());

        } catch (Exception e){
            log.error("Error when getFruitPage", e);
        }

        return null;
    }
}
