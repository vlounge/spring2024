package com.vlad.springUrfuApp.extern;

import com.vlad.springUrfuApp.app.DiscountLevelService;
import com.vlad.springUrfuApp.domain.DiscountLevelEntity;
import com.vlad.springUrfuApp.domain.ItemEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Класс контоллера, для работы с уровнями скидок
 */
@RestController
@RequestMapping("/api/discounts")

@AllArgsConstructor
@Slf4j
public class DiscountLevelController {

    DiscountLevelService discountLevelService;

    /**
     * Метод добавления уровня скидки
     * @return Добавленный уровень скидуи
     */
    @PostMapping
    public DiscountLevelDTO postDiscountLevel(@RequestBody DiscountLevelDTO discountLevelDTO){
        DiscountLevelEntity discountLevelEntity = discountLevelService.newDiscountLevel(new DiscountLevelEntity(
                discountLevelDTO.getLevelDiscountName(),
                discountLevelDTO.getDiscount()
        ));
        return DiscountLevelDTO.builder()
                .levelDiscountName(discountLevelEntity.getName())
                .discount(discountLevelEntity.getDiscount())
                .build();
    }
}
