package com.muxob.projectzero.auth.init;

import com.muxob.projectzero.auth.service.AuthServiceConfig;
import com.muxob.projectzero.auth.service.Role;
import com.muxob.projectzero.auth.service.User;
import com.muxob.projectzero.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;

@SpringBootApplication
@Import(AuthServiceConfig.class)
public class AuthInitApplication {

    @Value("${auth.superuser.name:superuser}")
    private String superuserName;

    @Value("${auth.superuser.pass:pass123}")
    private String superuserPass;

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(AuthInitApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder(11);
    }

    @Bean
    CommandLineRunner insertSuperUser() {
        User superUser = new User();
        superUser.setUsername(superuserName);
        superUser.setPassword(bCryptPasswordEncoder().encode(superuserPass));
        superUser.setRoles(Arrays.asList(
                userService.getOrCreateRoleIfNotPresent(Role.ADMIN_ROLE),
                userService.getOrCreateRoleIfNotPresent(Role.USER_ROLE)
        ));
        userService.saveUser(superUser);
        return null;
    }
}
