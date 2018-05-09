package com.muxob.projectzero.auth.authweb;

import com.muxob.projectzero.auth.service.AuthServiceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(AuthServiceConfig.class)
public class AuthWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthWebApplication.class, args);
	}
}
