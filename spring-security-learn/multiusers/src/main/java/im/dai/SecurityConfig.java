package im.dai;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @ClassName SecurityConfig
 * @author: roc
 * @date: 2020/9/10 上午 09:38
 * @version: 1.0
 * @description: 在用户身份认证时，两个 DaoAuthenticationProvider 会被依次执行，这样我们配置的两个数据源就生效了
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    @Primary
    UserDetailsService us1() {
        return new InMemoryUserDetailsManager(User.builder().username("admin").password("{noop}admin").roles("admin").build());
    }
    @Bean
    UserDetailsService us2() {
        return new InMemoryUserDetailsManager(User.builder().username("user").password("{noop}user").roles("user").build());
    }
    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        DaoAuthenticationProvider dao1 = new DaoAuthenticationProvider();
        dao1.setUserDetailsService(us1());

        DaoAuthenticationProvider dao2 = new DaoAuthenticationProvider();
        dao2.setUserDetailsService(us2());

        ProviderManager manager = new ProviderManager(dao1, dao2);
        return manager;
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/user").hasRole("user")
                .antMatchers("/admin").hasRole("admin")
                .and()
                .formLogin()
                .loginProcessingUrl("/doLogin")
                .permitAll()
                .and()
                .csrf().disable();
    }
}
