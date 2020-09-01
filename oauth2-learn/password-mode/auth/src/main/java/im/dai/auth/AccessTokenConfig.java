package im.dai.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

/**
 * @ClassName AccessTokenConfig
 * @author: roc
 * @date: 2020/8/28 上午 11:07
 * @version: 1.0
 * @description: TODO
 */
@Configuration
public class AccessTokenConfig {
    @Bean
    TokenStore tokenStore() {
        //存在内存中的TokenStore实例
        return new InMemoryTokenStore();
    }
}
