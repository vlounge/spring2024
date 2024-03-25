package com.vlad.springUrfuApp.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUserEntity,String> {}