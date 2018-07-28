package com.training.springcore;

import com.training.springcore.config.BigCorpApplicationConfig;
import com.training.springcore.model.ApplicationInfo;
import com.training.springcore.service.SiteService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BigCorpApplication {


    public static void main (String[] args){
        BigCorpApplication application = new BigCorpApplication();
        application.run();
    }

    public void run(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //context.getEnvironment().setActiveProfiles("dev", "cloud");
        context.register(BigCorpApplicationConfig.class);
        context.refresh();

        ApplicationInfo applicationInfo = context.getBean(ApplicationInfo.class);
        System.out.println("========================================================================");
        System.out.println("Application [" + applicationInfo.getName() + "] - version : " + applicationInfo.getVersion());
        System.out.println("plus d'informations sur " + applicationInfo.getWebSiteUrl());
        System.out.println("========================================================================");

        context.getBean(SiteService.class).findById("test");
    }
}
