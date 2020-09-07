package im.dai.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @ClassName SecurityConfig
 * @author: roc
 * @date: 2020/9/7 下午 05:32
 * @version: 1.0
 * @description: 请求头加参数，认证方式一
 * 这种方式比较通用，不仅仅适用于 OAuth2，也适用于其他一些自定义的 token 登录方式
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/swagger-ui.html")
                .antMatchers("/webjars/**")
                .antMatchers("/v2/**")
                .antMatchers("/swagger-resources/**");
    }
}