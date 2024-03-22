package com.hanil.edubot.config;

import com.hanil.edubot.service.member.security.HanilMemberDetailService;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
@Order(1)
public class UserSecurityConfig {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public HanilMemberDetailService hanilMemberDetailService(){
        return new HanilMemberDetailService();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(hanilMemberDetailService());
        provider.setPasswordEncoder(bCryptPasswordEncoder());
        return provider;
    }


    @Bean
    public WebSecurityCustomizer configure(){
        return (web) -> web.ignoring().requestMatchers("/checkUserId", "/login", "/signup", "/sub/**", "/pub/**", "/ws/**", "/edubot/api/**", "/test/**", "/hanil/ubase/**", "/monitoring/updateQueueId")
                .and()
                .ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws  Exception {

        return http
                .csrf(csrfConfigurer -> csrfConfigurer.disable())
                .authorizeHttpRequests(authorize ->
                        authorize.anyRequest().authenticated())
                .formLogin(form ->
                        form
                        .loginPage("/login")
                        .loginProcessingUrl("/loginProcessing")
                        .permitAll())
                .logout(logout ->
                        logout.logoutUrl("/logout").logoutSuccessUrl("/login"))
                .build();

    }

}
