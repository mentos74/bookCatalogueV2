package com.mentos74.catalogue.repository.impl;

import com.mentos74.catalogue.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    public Optional<AppUser> findByUserName(String username);
}
