package com.esoft.finalproject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.TimeUnit;
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class FinalProjectApplication implements WebMvcConfigurer {

	@Value("${archive.path}")
	private String archivePath;

    @Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// Register resource handler for images
		registry.addResourceHandler("/files/**").addResourceLocations("file:///" + archivePath + "/")
				.setCacheControl(CacheControl.maxAge(24, TimeUnit.HOURS).cachePublic());
	}


	public static void main(String[] args) {
		SpringApplication.run(FinalProjectApplication.class, args);
	}

}
