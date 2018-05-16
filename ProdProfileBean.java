package com.infotech.app.coonfig;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("prod")
public class ProdProfileBean implements EnvBasedCofig {

	@Override
	public void setup() {
		System.out.println("Prod config is setup..");
	}
}
