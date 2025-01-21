//package com.mentos74.catalogue.services.impl;
//
//import com.mentos74.catalogue.dto.UserDetailResponseDTO;
//import com.mentos74.catalogue.exception.ResourceNotFoundException;
//import com.mentos74.catalogue.repository.impl.AppUserRepository;
//import com.mentos74.catalogue.services.AppUserService;
//import lombok.AllArgsConstructor;
//import org.springframework.security.core.context.SecurityContext;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//
//@Service
//@AllArgsConstructor
//public class AppUserServiceImpl implements AppUserService {
//
//    private final AppUserRepository appUserRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return appUserRepository.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("invalid username"));
//    }
//
//    @Override
//    public UserDetailResponseDTO findUserDetail() {
//        SecurityContext  ctx = SecurityContextHolder.getContext();
//        UserDetailResponseDTO dto = new UserDetailResponseDTO();
//        dto.setUsername(ctx.getAuthentication().getName());
//        return dto;
//    }
//}
