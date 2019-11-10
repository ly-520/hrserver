package com.example.hrserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@MapperScan("com.example.hrserver.dao")
@SpringBootApplication
public class HrserverApplication {

  public static void main(String[] args) {
    SpringApplication.run(HrserverApplication.class, args);
  }

}
