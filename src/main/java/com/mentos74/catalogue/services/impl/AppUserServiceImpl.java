package com.mentos74.catalogue.services.impl;

import com.mentos74.catalogue.exception.ResourceNotFoundException;
import com.mentos74.catalogue.repository.impl.AppUserRepository;
import com.mentos74.catalogue.services.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


@AllArgsConstructor
public class AppUserServiceImpl implements AppUserService {

    private final AppUserRepository appUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return appUserRepository.findByUserName(username).orElseThrow(() -> new ResourceNotFoundException("invalid username"));
    }
}
