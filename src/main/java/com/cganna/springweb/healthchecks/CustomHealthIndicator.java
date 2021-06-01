package com.cganna.springweb.healthchecks;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthIndicator implements HealthIndicator {

	@Override
	public Health health() {
		 Boolean error = true;
		 
		 if(error.booleanValue()) {
			 return Health.down().withDetail("Error", 123).build();
		 }
		
		return Health.up().build();
	}

}
