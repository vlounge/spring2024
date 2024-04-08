package com.vlad.springUrfuApp.app;

import com.vlad.springUrfuApp.domain.BuyerEntity;
import com.vlad.springUrfuApp.domain.OrderItemLinkEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemLinkRepository extends JpaRepository<OrderItemLinkEntity,String> {}