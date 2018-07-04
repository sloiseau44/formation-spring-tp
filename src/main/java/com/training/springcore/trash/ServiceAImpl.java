package com.training.springcore.trash;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ServiceAImpl implements ServiceA, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    private ServiceB createServiceB(){
        return applicationContext.getBean(ServiceB.class);
    }

    // reste du code

}
