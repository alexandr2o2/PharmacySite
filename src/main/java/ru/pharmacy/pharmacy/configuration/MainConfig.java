package ru.pharmacy.pharmacy.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class MainConfig {

    @Bean(name = "loggerBean")
    public Logger logger(){
        return LoggerFactory.getLogger("app");
    }

}
