package com.mentos74.catalogue.services.impl;


import com.mentos74.catalogue.config.ApplicationProperties;
import com.mentos74.catalogue.config.CloudProperties;
import com.mentos74.catalogue.services.GreetingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.nio.file.ClosedDirectoryStreamException;
import java.util.TimeZone;


@Service
public class GreetingServicesImpl implements GreetingServices {

//    @Autowired
    private ApplicationProperties applicationProperties;

//    @Autowired
    private CloudProperties cloudProperties;

    public GreetingServicesImpl(ApplicationProperties applicationProperties, CloudProperties cloudProperties) {
        super();
        this.applicationProperties = applicationProperties;
        this.cloudProperties = cloudProperties;
    }

//    @Value("${welcome.text}")
//    private String welcomeText = "";
//
//    @Value("${timezone}")
//    private String timeZone = "";
//
//
//    @Value("${currency}")
//    private String currency = "";


    @Override
    public String sayGreeting() {
        TimeZone timeZone = TimeZone.getTimeZone(applicationProperties.getTimeZone());
        System.out.println("jir >>>"+cloudProperties.getApiKey());
        return applicationProperties.getWelcomeText() + ";" + timeZone.getDisplayName() + ";" + applicationProperties.getCurrency();
    }
}
