package com.vlad.springUrfuApp.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<ItemEntity,String>{}
