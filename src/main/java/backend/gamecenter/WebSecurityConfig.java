package backend.gamecenter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity(securedEnabled = true)

public class WebSecurityConfig {

        @Bean
        public BCryptPasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder();
        }

        @Bean
        public SecurityFilterChain configure(HttpSecurity http) throws Exception {
                http
                                .authorizeHttpRequests(authorize -> authorize
                                                .requestMatchers("/css/**").permitAll() // Enable css when logged out

                                                .requestMatchers("/", "/index", "/gamelist").permitAll()
                                                // Enable when logged out

                                                .requestMatchers("/delete/**").hasAuthority("ADMIN")
                                                .requestMatchers("/createplatform", "/saveplatform")
                                                .hasAuthority("ADMIN")

                                                .anyRequest().authenticated())

                                .formLogin(formlogin -> formlogin
                                                .loginPage("/login")
                                                .defaultSuccessUrl("/index", true)
                                                .permitAll())

                                .logout(logout -> logout
                                                .permitAll());
                return http.build();
        }

}
