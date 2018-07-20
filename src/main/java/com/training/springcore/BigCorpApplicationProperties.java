package com.training.springcore;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Set;

@ComponentScan
@Configuration
@PropertySource("classpath:application.properties")
@PropertySource(value = "classpath:version.properties", ignoreResourceNotFound=true)
public class BigCorpApplicationProperties {

    @Value("${myapp.name}")
    private String name;

    @Value("${myapp.version}")
    private Integer version;

    @Value("${myapp.emails}")
    private Set<String> emails;


    @Bean
    public ApplicationInfo applicationInfo(){
        return new ApplicationInfo(name, version, emails);
    }


    public static class ApplicationInfo{
        private String name;

        private Integer version;

        private Set<String> emails;

        public ApplicationInfo(String name, Integer version, Set<String> emails) {
            this.name = name;
            this.version = version;
            this.emails = emails;
        }

        public String getName() {
            return name;
        }

        public Integer getVersion() {
            return version;
        }

        public Set<String> getEmails() {
            return emails;
        }
    }
}
