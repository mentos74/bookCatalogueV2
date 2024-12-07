package com.mentos74.catalogue.services.impl;


import com.mentos74.catalogue.config.ApplicationProperties;
import com.mentos74.catalogue.config.CloudProperties;
import com.mentos74.catalogue.services.GreetingServices;
import org.springframework.stereotype.Service;

import java.nio.file.ClosedDirectoryStreamException;
import java.util.TimeZone;


@Service
public class GreetingServicesImpl implements GreetingServices {

    private ApplicationProperties appProperties;


    private CloudProperties cloudProperties;



    public GreetingServicesImpl(ApplicationProperties appProperties, CloudProperties cloudProperties) {
        super();
        this.appProperties = appProperties;
        this.cloudProperties = cloudProperties;
    }



    @Override
    public String sayGreeting() {
        System.out.println(cloudProperties.getApiKey());
        TimeZone timezone = TimeZone.getTimeZone(appProperties.getTimezone());
        return appProperties.getWelcomeText()+", our timezone :"+timezone.getDisplayName()+
                ", our currency:"+appProperties.getCurrency();
    }


}
