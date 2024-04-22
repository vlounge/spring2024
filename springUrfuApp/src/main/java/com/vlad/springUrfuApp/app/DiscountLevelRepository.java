package com.vlad.springUrfuApp.app;


import com.vlad.springUrfuApp.domain.DiscountLevelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountLevelRepository extends JpaRepository<DiscountLevelEntity,String> {}
