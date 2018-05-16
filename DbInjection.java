package com.infotech.app.injection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DbInjection {
	@Value(value = "${welcome.message}")
	private String message;
	@Value(value = "${spring.datasource.url}")
	private String datasource;
	@Value(value = "${spring.datasource.username}")
	private String username;
	@Value(value = "${spring.datasource.password}")
	private String password;

	public String getMessage() {
		return message;
	}

	public String getDatasource() {
		return datasource;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

}
