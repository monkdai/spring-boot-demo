package im.dai;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.www.DigestAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.DigestAuthenticationFilter;

/**
 * @ClassName SecurityConfig
 * @author: roc
 * @date: 2020/9/8 上午 10:44
 * @version: 1.0
 * @description: Http摘要认证流程
 * 浏览器发出请求，要访问 /hello 接口。
 * 服务端返回 401，表示未认证，同时在响应头中携带 WWW-Authenticate 字段来描述认证形式。
 * 不同的是，这次服务端会计算出一个随机字符串，一同返回前端，这样可以防止重放攻击。
 * （所谓重放攻击就是别人嗅探到你的摘要信息，把摘要当成密码一次次发送服务端，加一个会变化的随机字符串，生成的摘要信息就会变化，就可以防止重放攻击）
 * 同时，服务端返回的字段还有一个 qop，表示保护级别，auth 表示只进行身份验证；auth-int 表示还要校验内容。
 * nonce 是服务端生成的随机字符串，这是一个经过 Base64 编码的字符串，经过解码我们发现，它是由过期时间和密钥组成的。在以后的请求中 nonce 会原封不动的再发回给服务端。
 *
 * 简之：原本的用户密码被摘要信息代替了。
 * 为了安全，摘要信息会根据服务端返回的随机字符串而发生变化，服务端根据用户密码，同样算出密码的摘要信息，再和客户端传来的摘要信息进行对比，没问题的话，用户就算认证成功了。
 * 当然，在此基础上还加了一些过期限制、重放攻击防范机制等
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .csrf()
                .disable()
                .exceptionHandling()
                .authenticationEntryPoint(digestAuthenticationEntryPoint())
                .and()
                .addFilter(digestAuthenticationFilter());
    }

    @Bean
    DigestAuthenticationEntryPoint digestAuthenticationEntryPoint() {
        DigestAuthenticationEntryPoint entryPoint = new DigestAuthenticationEntryPoint();
        entryPoint.setKey("mykey");
        entryPoint.setRealmName("myrealm");
        entryPoint.setNonceValiditySeconds(1000);
        return entryPoint;
    }
    @Bean
    DigestAuthenticationFilter digestAuthenticationFilter() {
        DigestAuthenticationFilter filter = new DigestAuthenticationFilter();
        filter.setAuthenticationEntryPoint(digestAuthenticationEntryPoint());
        filter.setUserDetailsService(userDetailsService());
        return filter;
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("admin").password("admin").roles("admin").build());
        return manager;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}
