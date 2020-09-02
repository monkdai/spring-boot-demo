package im.dai.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @ClassName CustomAdditionalInformation
 * @author: roc
 * @date: 2020/9/1 上午 10:03
 * @version: 1.0
 * @description: 这里 JWT 默认生成的用户信息主要是用户角色、用户名等，此方法在生成的 JWT 上面添加额外的信息
 * 自定义类 CustomAdditionalInformation 实现 TokenEnhancer 接口，并实现接口中的 enhance 方法。
 * enhance 方法中的 OAuth2AccessToken 参数就是已经生成的 access_token 信息，我们可以从 OAuth2AccessToken 中取出已经生成的额外信息，然后在此基础上追加自己的信息。
 */
@Component
public class CustomAdditionalInformation implements TokenEnhancer {

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        Map<String, Object> info = accessToken.getAdditionalInformation();
        info.put("author", "roc");
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
        return accessToken;
    }
}
