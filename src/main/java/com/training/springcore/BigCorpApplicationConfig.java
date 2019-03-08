package com.training.springcore;

import com.training.springcore.service.CaptorService;
import com.training.springcore.service.CaptorServiceImpl;
import com.training.springcore.service.SiteService;
import com.training.springcore.service.SiteServiceImpl;
import org.springframework.context.annotation.Bean;

public class BigCorpApplicationConfig {
    @Bean
    public SiteService siteService() {
        return new SiteServiceImpl(captorService());
    }
    @Bean
    public CaptorService captorService() {
        return new CaptorServiceImpl();
    }

}
