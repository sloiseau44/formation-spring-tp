package com.training.springcore.trash;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

@Component
public class ServiceAImpl implements ServiceA, ApplicationContextAware {

    @Autowired
    private Environment environment;

    @Autowired
    private ResourceLoader resourceLoader;

    private ApplicationContext applicationContext;


    @PostConstruct
    public void postConstruct() throws IOException {
        System.out.println("Service A post construct");
        Resource resource = resourceLoader.getResource("url:https://dev-mind.fr");

        try (InputStream stream = resource.getInputStream()) {
            Scanner scanner = new Scanner(stream).useDelimiter("\\n");
            while (scanner.hasNext()) {
                System.out.println(scanner.next());
            }
        }
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("Service A pre destroy");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("App context ready");
        this.applicationContext = applicationContext;

        Runnable stop = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ((AbstractApplicationContext) this.applicationContext).registerShutdownHook();
        };
        //stop.run();
    }

    private ServiceB createServiceB() {
        return applicationContext.getBean(ServiceB.class);
    }

    // reste du code

}
