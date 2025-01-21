//package com.mentos74.catalogue.domain;
//
//import jakarta.persistence.*;
//import lombok.Data;
//import org.springframework.security.core.GrantedAuthority;
//
//import java.io.Serial;
//
//@Table(name = "role")
//@Entity
//@Data
//public class Role implements GrantedAuthority {
//    @Serial
//    private static final long serialVersionUID = 1446530758920244637L;
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    @Column(name = "name")
//    private String name;
//
//    @Override
//    public String getAuthority() {
//        return "ROLE_"+name;
//    }
//}
