package com.mentos74.catalogue.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix ="cloud")
@Data
public class CloudProperties {


    private String apiKey;
}
