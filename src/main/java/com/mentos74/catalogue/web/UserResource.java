//package com.mentos74.catalogue.web;
//
//import com.mentos74.catalogue.dto.UserDetailResponseDTO;
//import com.mentos74.catalogue.services.AppUserService;
//import lombok.AllArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@AllArgsConstructor
//@RestController
//public class UserResource {
//
//    private final AppUserService userService;
//
//    @GetMapping("v1/user")
//    public ResponseEntity<UserDetailResponseDTO> findUserDetail() {
//        return ResponseEntity.ok().body(userService.findUserDetail());
//    }
//
//}
