package com.vlad.springUrfuApp.app;

import com.vlad.springUrfuApp.domain.BuyerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyerRepository extends JpaRepository<BuyerEntity,String> {}
