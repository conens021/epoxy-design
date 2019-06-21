package com.abstractmedia.projects.epoxydesign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@EnableRedisHttpSession
public class EpoxyDesignApplication {

	public static void main(String[] args) {
		SpringApplication.run(EpoxyDesignApplication.class, args);
	}

}
	