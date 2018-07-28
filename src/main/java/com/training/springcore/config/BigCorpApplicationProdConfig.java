package com.training.springcore.config;

import com.training.springcore.model.ApplicationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

import java.util.Set;

@Configuration
@PropertySource("classpath:application-prod.properties")
@Profile("prod")
public class BigCorpApplicationProdConfig {

    @Autowired
    private Environment environment;

    @Value("${myapp.webSiteUrl}")
    private String webSiteUrl;

    @Bean
    public ApplicationInfo applicationInfo() {
        String name = environment.getRequiredProperty("myapp.name");
        Integer version = environment.getProperty("myapp.versionss", Integer.class, 3);
        Set<String> emails = environment.getRequiredProperty("myapp.emails", Set.class);

        return new ApplicationInfo(name, version, emails, webSiteUrl);
    }
}
