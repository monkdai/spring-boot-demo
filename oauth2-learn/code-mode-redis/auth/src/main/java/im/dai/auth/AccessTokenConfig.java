package im.dai.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * @ClassName AccessTokenConfig
 * @author: roc
 * @date: 2020/8/28 上午 11:07
 * @version: 1.0
 * @description: TODO
 */
@Configuration
public class AccessTokenConfig {
    @Autowired
    RedisConnectionFactory redisConnectionFactory;

    @Bean
    TokenStore tokenStore() {
        //将token令牌存在redis中
        return new RedisTokenStore(redisConnectionFactory);
    }
}
