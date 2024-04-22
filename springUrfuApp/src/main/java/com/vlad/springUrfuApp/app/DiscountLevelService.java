package com.vlad.springUrfuApp.app;

import com.vlad.springUrfuApp.domain.DiscountLevelEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Класс сервиса для работы с уровнями скидок
 */
@Service

@AllArgsConstructor
@Slf4j
public class DiscountLevelService {
    private final DiscountLevelRepository discountLevelRepository;

    /**
     * Метод возваращающий все уровни скидок
     * @return все уровни скидок
     */
    public List<DiscountLevelEntity> getAllDiscountLevels(){
        return discountLevelRepository.findAll();
    }

    /**
     * Метод создающий уровень скидки
     * @param discountLevelEntity entity нового уровня скидуи
     * @return id нового уровня скидки
     */
    public DiscountLevelEntity newDiscountLevel(DiscountLevelEntity discountLevelEntity){
        return discountLevelRepository.save(discountLevelEntity);
    }
}
