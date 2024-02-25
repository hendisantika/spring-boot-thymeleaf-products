package id.my.hendisantika.springbootthymeleafproducts.config;

import id.my.hendisantika.springbootthymeleafproducts.service.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-thymeleaf-products
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2/25/24
 * Time: 11:30
 * To change this template use File | Settings | File Templates.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {
//    @Autowired
//    private UserDetailsService userDetailsService;

//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;

//    @Bean
//    protected SecurityFilterChain configure(AuthenticationManagerBuilder auth) throws Exception {
//        return auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
//    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            final AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/login")
//                .permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .csrf()
//                .disable()
//                .formLogin()
//                .loginPage("/login")
//                .failureUrl("/login?error=true")
//                .defaultSuccessUrl("/products/page")
//                .usernameParameter("username")
//                .passwordParameter("password")
//                .and()
//                .logout()
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                .logoutSuccessUrl("/login")
//                .and()
//                .exceptionHandling()
//                .accessDeniedPage("/access-denied")
//        ;
//    }

    @Bean
    public SecurityFilterChain configure(final HttpSecurity http) throws Exception {
        return http.cors(withDefaults())
                .csrf(withDefaults())
                .authorizeHttpRequests(authorize -> authorize.anyRequest().permitAll())
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/products/page")
                        .usernameParameter("username")
                        .passwordParameter("password")
                        .failureUrl("/login?loginError=true"))
                .logout(logout -> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/login?logoutSuccess=true")
                        .deleteCookies("JSESSIONID"))
                .exceptionHandling(exception -> exception
                        .authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/login?loginRequired=true")))
                .build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/images/**", "/js/**", "/css/**", "/webjars/**");
    }
}
