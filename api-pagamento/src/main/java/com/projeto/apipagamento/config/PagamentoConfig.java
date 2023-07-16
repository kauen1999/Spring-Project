package com.projeto.apipagamento.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PagamentoConfig {

    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }
}
