package com.example.julio.bookstore.config;

import com.example.julio.bookstore.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {
    @Autowired
    private DBService dbService;


    public void instanciaBaseDeDados(){
        this.dbService.instaciaBaseDeDados();
    }
}
