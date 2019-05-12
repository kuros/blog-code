package in.kuros.config;

import in.kuros.custom.CustomAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired private CustomAuthenticationProvider customAuthenticationProvider;

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .headers()
                .frameOptions().sameOrigin();

        http
                .csrf()
                .disable();

        http
                .authorizeRequests()
                .antMatchers("/books").permitAll()
                .antMatchers("/secured/**").authenticated();
        http
                .formLogin();
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(customAuthenticationProvider);
    }
}
