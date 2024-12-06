package com.mentos74.catalogue.web;

import com.mentos74.catalogue.services.GreetingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


    public HelloController(GreetingServices gs) {
        this.gs = gs;
    }

//    @Autowired
    private GreetingServices gs;




    @GetMapping("/kucing")
    public String hello(){

        return gs.sayGreeting();
    }
}
