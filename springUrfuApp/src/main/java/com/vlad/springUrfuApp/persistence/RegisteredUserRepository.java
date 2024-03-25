package com.vlad.springUrfuApp.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisteredUserRepository extends JpaRepository<RegisteredUserEntity,String> {}