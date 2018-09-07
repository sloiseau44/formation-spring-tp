package com.training.springcore;

import com.training.springcore.service.SiteService;

public class BigCorpApplication {

    public static void main (String[] args){
        BigCorpApplication application = new BigCorpApplication();
        application.run();
    }

    public void run(){
        System.out.println("Application startup");
        ObjectFactory objectFactory = new ObjectFactory();
        SiteService siteService = objectFactory.createSiteService();
        System.out.println(siteService.findById("siteA"));
    }
}
