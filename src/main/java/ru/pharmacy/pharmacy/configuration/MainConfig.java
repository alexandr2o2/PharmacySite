package ru.pharmacy.pharmacy.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConfig {


    @Bean
    @Qualifier("lolBean")
    public CommandLineRunner first() {
        return (args) -> {
            String str = "";
            System.out.println(":LOL");
        };
    }

}
