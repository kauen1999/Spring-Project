package com.projeto.apicarrinhoproduto.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.projeto.apicarrinhoproduto.client")
public class CarrinhoProdutoConfig {
    // Configurações adicionais, se necessário
}
