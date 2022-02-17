package com.example.julio.bookstore.config;

import com.example.julio.bookstore.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevConfig {
    @Autowired

    private DBService dbService;

    //pega o valor do application-dev.properties pelo @Value()
    @Value("${spring.jpa.hibernate.ddl-auto}")
    public String strategy;

    //Se strategy la do arquivo application-dev.properties for create ele chama o metodo instaciaBaseDeDados
    @Bean
    public boolean instanciaBancoDeDados(){
        if (strategy.equals("create")){
            dbService.instaciaBaseDeDados();
        }
        return false;
    }
}
