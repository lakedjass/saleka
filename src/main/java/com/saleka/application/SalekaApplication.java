package com.saleka.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SalekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalekaApplication.class, args);
	}
}

/*@Configuration
static class SecurityConfig extends GlobalAuthenticationConfigurerAdapter {

	@Override
	public void init(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication()
				.withUser("user").password("user").roles("USER").and()
				.withUser("hero").password("hero").roles("USER", "HERO");
	}
}*/
