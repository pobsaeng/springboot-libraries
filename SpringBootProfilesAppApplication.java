package com.infotech.app;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.infotech.app.coonfig.EnvBasedCofig;

@SpringBootApplication
public class SpringBootProfilesAppApplication implements CommandLineRunner{

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private EnvBasedCofig envBasedCofig;
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootProfilesAppApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		System.out.println("------------------------------------------");
		System.out.println("Catalog = "+dataSource.getConnection().getCatalog());
		System.out.println("------------------------------------------");
		
		envBasedCofig.setup();
	}
}
