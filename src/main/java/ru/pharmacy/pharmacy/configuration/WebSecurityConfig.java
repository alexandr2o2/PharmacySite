package ru.pharmacy.pharmacy.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    private static final String[] AUTH_WHITELIST = {
            // -- swagger ui
            "/v2/api-docs",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**"
    };

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity
//                .csrf()
//                .disable()
//                .authorizeRequests()
//                // Доступ для swagger
//                .antMatchers(AUTH_WHITELIST).permitAll().
//                antMatchers("/**").authenticated()
//                //Доступ только для не зарегистрированных пользователей
//                .antMatchers("/registration","/manufacturer","/find/manufacturers").not().fullyAuthenticated()
//                //Доступ только для пользователей с ролью Администратор
//                .antMatchers("/admin/**").hasRole("ADMIN")
//                //.antMatchers("/**").hasRole("USER")
//                //Доступ разрешен всем пользователей
//                .antMatchers("/","/find/manufacturers").permitAll()
//                //Все остальные страницы требуют аутентификации
//                .anyRequest().authenticated()
//                .and()
//                //Настройка для входа в систему
//                .formLogin()
//                .loginPage("/login")
//                //Перенарпавление на главную страницу после успешного входа
//                .defaultSuccessUrl("/").permitAll()
//                .and()
//                .logout().permitAll()
//                .logoutSuccessUrl("/");
//
//        return httpSecurity.build();
        return httpSecurity
                .anonymous(AbstractHttpConfigurer::disable)         // AnonymousAuthenticationFilter
                .csrf(AbstractHttpConfigurer::disable)              // CsrfFilter
                .sessionManagement(AbstractHttpConfigurer::disable) // DisableEncodeUrlFilter, SessionManagementFilter
                .exceptionHandling(AbstractHttpConfigurer::disable) // ExceptionTranslationFilter
                .headers(AbstractHttpConfigurer::disable)           // HeaderWriterFilter
                .logout(AbstractHttpConfigurer::disable)            // LogoutFilter
                .requestCache(AbstractHttpConfigurer::disable)      // RequestCacheAwareFilter
                .servletApi(AbstractHttpConfigurer::disable)        // SecurityContextHolderAwareRequestFilter
                .securityContext(AbstractHttpConfigurer::disable)   // SecurityContextPersistenceFilter
                .build();
    }

}
