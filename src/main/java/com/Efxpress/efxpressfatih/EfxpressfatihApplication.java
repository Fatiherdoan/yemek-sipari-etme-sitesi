package com.Efxpress.efxpressfatih;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.efExpress.controller", "com.efExpress.Service" ,"com.efExpress.config"})
public class  EfxpressfatihApplication {

	public static void main(String[] args) {
		SpringApplication.run(EfxpressfatihApplication.class, args);
	}

}
