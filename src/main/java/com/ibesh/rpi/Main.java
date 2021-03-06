package com.ibesh.rpi;

import com.ibesh.rpi.service.DhtService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = "file:app.properties")
public class Main {
    @Bean
    public CommandLineRunner demo(DhtService dhtService) {
        return env ->
        {
            System.out.println("Started>>>");
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
