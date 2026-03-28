package com.jforce.selenium.config;

import java.time.Duration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;


@Data
@ConfigurationProperties
@Component
public class SeleniumProperties {

	private String username;
	private String password;
	private String baseUrl;
	private String loginUrl;
	private String browser;
	private boolean grid;
	private boolean headless;
	private String gridUrl;
	private String gridToken;
	private Duration explicitTimeout;
	private String oid_token_key ;
	
}
