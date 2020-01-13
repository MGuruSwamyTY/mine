package com.tyss.Bussinessmanagement.ORM;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@Configuration
public class ORMConfig {
	@Bean
	public LocalEntityManagerFactoryBean ormConfig() {
		LocalEntityManagerFactoryBean bean = new LocalEntityManagerFactoryBean();
		bean.setPersistenceUnitName("Business");
		return bean;
	}
}
