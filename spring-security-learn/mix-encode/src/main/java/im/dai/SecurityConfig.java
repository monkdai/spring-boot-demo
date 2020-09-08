package im.dai;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @ClassName SecurityConfig
 * @author: roc
 * @date: 2020/9/8 下午 02:05
 * @version: 1.0
 * @description: TODO
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    @Bean
    protected UserDetailsService userDetailsService() {

        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("admin").password("{bcrypt}$2a$10$4Wfg7m7MwHuP0xROeUsWuuwv/tCUPi8eOaNNWm9rwWyYShZb7Qzk.").roles("admin").build());
        manager.createUser(User.withUsername("user").password("{MD5}{LbqENvNPvXIgfqbtl5i1rt6CX5YdhU2BAru4aVzqvdc=}eb95a8a2ddc65b5bb527565ab57174d2").roles("user").build());
        manager.createUser(User.withUsername("dai").password("{noop}dai").roles("dai").build());
        return manager;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/**").hasRole("admin")
                .antMatchers("/user/**").hasRole("user")
                .antMatchers("/dai/**").hasRole("dai")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginProcessingUrl("/doLogin")
                .permitAll()
                .and()
                .csrf()
                .disable();
    }
}
