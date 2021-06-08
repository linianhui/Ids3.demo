package api.configuration;

import api.handler.CustomizedAccessDeniedHandler;
import api.handler.CustomizedAuthenticationEntryPoint;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsUtils;

@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .sessionManagement().disable()
            .authorizeRequests()
                .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
            .antMatchers("/**")
                .hasAuthority("SCOPE_api-1")
            .anyRequest()
                .authenticated()
            .and()
            .exceptionHandling()
                .authenticationEntryPoint(new CustomizedAuthenticationEntryPoint())
                .accessDeniedHandler(new CustomizedAccessDeniedHandler());

        http.oauth2ResourceServer()
            .jwt();
    }
}
