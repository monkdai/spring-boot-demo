package im.dai;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * @ClassName SecurityConfig
 * @author: roc
 * @date: 2020/9/2 下午 03:51
 * @version: 1.0
 * @description: 方案二：配置类
 * BCryptPasswordEncoder 使用 BCrypt 强哈希函数，开发者在使用时可以选择提供 strength 和 SecureRandom 实例。
 * strength 越大，密钥的迭代次数越多，密钥迭代次数为 2^strength。strength 取值在 4~31 之间，默认为 10。
 * 相对比 shiro 需要自己处理密码加盐，BCryptPasswordEncoder 就自带了盐。
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
        //return new BCryptPasswordEncoder();
    }

    /**
     * 自定义用户名/密码
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("admin")
                //.password(new BCryptPasswordEncoder().encode("admin"))
                .roles("admin")
                .and()  //多个用户用 and() 相连
                .withUser("user")
                .password("user")
                //.password(new BCryptPasswordEncoder().encode("user"))
                .roles("user");
    }

    /**
     * 自定义登录页面
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        //web.ignoring() 用来配置忽略掉的 URL 地址，一般对于静态文件
        web.ignoring().antMatchers("/js/**","/css/**","/images/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //authorizeRequests 对应了 <intercept-url>
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()    //formLogin 对应了 <form-login>
                .loginPage("/login.html")   //此时登录接口和登录页面都是 /login.html
                //.loginProcessingUrl("/doLogin")     //这样分开配置，则需要在表单提交处修改登录接口

                //.usernameParameter("name")    //与表单提交一一对应
                //.passwordParameter("pwd")

                .defaultSuccessUrl("/index.html",true)  //默认是false，当从登录页面登录成功后才跳转到index.html，true的话和successForwardUrl一样
                //.successForwardUrl("/index.html")  //只需要配置一个

                //.failureForwardUrl("/404.html") //服务端跳转
                .failureUrl("/404.html") //重定向

                /*.and()
                .logout()
                .logoutUrl("/logout")
                //.logoutRequestMatcher(new AntPathRequestMatcher("/logout","POST"))  //可以修改注销 URL 和请求方式，和 logoutUrl 任意设置一个即可
                .logoutSuccessUrl("/success.html")
                .deleteCookies()
                .clearAuthentication(true).invalidateHttpSession(true)  //清除认证信息和使 HttpSession 失效，默认清除，无需设置*/

                .permitAll() //permitAll 表示登录相关的页面/接口不要被拦截
                .and()
                .csrf().disable();
    }

}
