package com.upc.pre.peaceapp.iam.infrastructure.authorization.sfs.configuration;

import com.upc.pre.peaceapp.iam.infrastructure.authorization.sfs.pipeline.BearerAuthorizationRequestFilter;
import com.upc.pre.peaceapp.iam.infrastructure.tokens.jwt.BearerTokenService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration {

    private final BearerTokenService tokenService;
    private final UserDetailsService userDetailsService;

    public WebSecurityConfiguration(
            BearerTokenService tokenService,
            @Qualifier("defaultUserDetailsService") UserDetailsService userDetailsService
    ) {
        this.tokenService = tokenService;
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .formLogin(form -> form.disable())  // 🔥 evita redirección a /login
                .httpBasic(basic -> basic.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("api/v1/authentication/sign-in", "api/v1/authentication/sign-up").permitAll()
                        .anyRequest().authenticated()
                );

        http.addFilterBefore(
                new BearerAuthorizationRequestFilter(tokenService, userDetailsService),
                UsernamePasswordAuthenticationFilter.class
        );

        return http.build();
    }
}
