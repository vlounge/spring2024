package com.vlad.springUrfuApp.app;

import com.vlad.springUrfuApp.domain.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepository extends JpaRepository<ItemEntity,String>{
    
    /**
     * Метод возвращающий товары подтвержденные администратором
     * @return лист всех товаров подтвержденных администратором
     */
    @Query("SELECT c FROM ItemEntity c WHERE c.adminConfirm = true")
    List<ItemEntity> findAllConfirmedByAdmin();
}
