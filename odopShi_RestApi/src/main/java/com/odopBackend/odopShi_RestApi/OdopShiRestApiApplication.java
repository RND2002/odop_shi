package com.odopBackend.odopShi_RestApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan
public class OdopShiRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OdopShiRestApiApplication.class, args);
	}

}
