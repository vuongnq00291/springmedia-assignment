package com.springmedia.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:remote-services.yaml")
@ConfigurationProperties
public class RemoteServicesConfig {

	private Map<String,APIConfig> apis = new HashMap<String,APIConfig>();

	public Map<String,APIConfig> getApis() {
		return apis;
	}

	public void setApis(Map<String,APIConfig> apis) {
		this.apis = apis;
	}


}