package com.vlad.springUrfuApp.app;

import com.vlad.springUrfuApp.domain.RegisteredUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisteredUserRepository extends JpaRepository<RegisteredUserEntity,String> {}