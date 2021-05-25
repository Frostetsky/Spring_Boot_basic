package com.nikita.spring_boot_rest_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootRestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRestApiApplication.class, args);
    }

}

// Spring Boot Data Rest - автоматически создаёт необходимые мапинги для CRUD операций.

// Spring Boot Actuator предоставляет готовые конечные точки (endpoints), с помощью которых мониторится приложение.
// actuator/health - информация о статусе приложения.
// actuator/info - информация о приложении.
// actuator/beans - информация о всех бинах, зарегистрированных в Spring Container.
// actuator/mappings - Информация о всех Mapping-aх.