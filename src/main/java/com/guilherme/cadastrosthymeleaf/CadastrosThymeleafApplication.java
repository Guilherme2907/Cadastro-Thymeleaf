package com.guilherme.cadastrosthymeleaf;

import java.util.TimeZone;
import javax.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CadastrosThymeleafApplication {

    public static void main(String[] args) {
        SpringApplication.run(CadastrosThymeleafApplication.class, args);
    }

//    @PostConstruct
//    public void started() {
//        TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));
//    }

}
