package com.odopBackend.odopShi_RestApi.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig  {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                //.csrf().disable()
//                .authorizeRequests()
//                .requestMatchers("/public/**").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                //.loginPage("/login")
//                .permitAll()
//                //.and()
//                .logout()
//                .permitAll();
//    }
@Bean
SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

    http.authorizeHttpRequests(
            auth -> {
                auth.requestMatchers("/public").authenticated()
                        .anyRequest().authenticated();
            });

    http.sessionManagement(
            session ->
                    session.sessionCreationPolicy(
                            SessionCreationPolicy.STATELESS)
    );

    //http.formLogin();
    http.httpBasic(Customizer.withDefaults());

    http.csrf(csrf -> csrf.disable());

    //http.csrf(AbstractHttpConfigurer::disable);

    http.headers(headers -> headers.frameOptions(frameOptionsConfig-> frameOptionsConfig.disable()));

    // http.headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable));

    return http.build();
}
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(customUserDetailsService);
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

