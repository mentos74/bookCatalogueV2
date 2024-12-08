package com.mentos74.catalogue.web;

import com.mentos74.catalogue.services.GreetingServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloResource {
    Logger log = LoggerFactory.getLogger(HelloResource.class);

    public HelloResource(GreetingServices gs) {
        this.gs = gs;
    }

//    @Autowired
    private GreetingServices gs;




    @GetMapping("/kucing")
    public String hello(){
    log.info("kore wa roggu no info");
    log.warn("kore wa roggu no warn");
    log.debug("kore wa roggu no debugg");
    log.error("kore wa roggu no error");
    log.trace("kore wa roggu no trace");
        return gs.sayGreeting();
    }
}
